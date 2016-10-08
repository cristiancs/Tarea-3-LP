import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Cristian Navarrete on 27-09-16.
 */
public class UnJugador implements ModoJuego{

    private Sansano jugador, pc;
    private PlayView view;
    private Duelo juego;
    private Object carta;
    private int ModoJuego;

    public void iniciar(ModoJuegoView oldScreen, Sansano p1, Sansano p2) {

        oldScreen.setVisible(false);
        view = new PlayView();
        pc = p2;
        jugador = p1;
        String nombre = null;
        while ((nombre == null) || nombre.isEmpty()) {
            nombre = JOptionPane.showInputDialog(view, "Introduzca su nombre:");

        }
        String[] opciones = {"Modo Agresivo", "Modo Defensivo"};
        int opcion = -1;
        while (opcion == -1) {
            opcion = JOptionPane.showOptionDialog(
                    null                             //componente
                    , "Elija un Modo de Juego"            // Mensaje
                    , "Opciones Personalizada"         // Titulo en la barra del cuadro
                    , JOptionPane.DEFAULT_OPTION       // Tipo de opciones
                    , JOptionPane.INFORMATION_MESSAGE  // Tipo de mensaje (icono)
                    , null                             // Icono (ninguno)
                    , opciones                         // Opciones personalizadas
                    , null                             // Opcion por defecto
            );
        }
        jugador.setName(nombre);
        view.setNombreJugador(nombre);

        view.setprioridadEnemigo("3000");
        view.setprioridadUsuario("3000");
        view.setNumeroTurno("1");
        view.setUltimaAccion("");
        ModoJuego = opcion;
        asignarCartas(jugador, pc);
        juego = new Duelo();
    }

    public void DesarrolloJuego (){

        JButton atacarButton = view.getAtacarButton();
        JButton defendermeButton = view.getDefendermeButton();
        carta = null;

        atacarButton.addActionListener(e -> {
            Globales.setModoUso("ataque");
            if (carta != null) {
                ((Curso) carta).activar(pc);
            }
            juegoBot();
            carta = Globales.DesarrolloJugada(juego, view, jugador, pc);
        });

        defendermeButton.addActionListener(e -> {
            Globales.setModoUso("defensa");
            ((Carta)carta).activar(jugador);
            juegoBot();
            carta = Globales.DesarrolloJugada(juego, view, jugador, pc);
        });
        carta = Globales.DesarrolloJugada(juego, view, jugador, pc);
    }


    private void juegoBot(){
        Object carta = this.pc.getCard();
        juego.advanceTurno();
        view.setNumeroTurno(String.valueOf(juego.getTurno()));
        if (carta instanceof Curso) {
            int rand = ThreadLocalRandom.current().nextInt(0, 2);
            if(rand == 1){
                Globales.setModoUso("defensa");
                ((Curso )carta).activar(pc);
                view.setUltimaAccion("PC se defiende, obtiene "+String.valueOf(((Curso )carta).getPuntosHabilidad("defensa"))+ " puntos de prioridad");
            }
            else{
                Globales.setModoUso("ataque");
                ((Curso )carta).activar(jugador);
                view.setUltimaAccion("PC ataca con "+String.valueOf(((Curso)carta).getPuntosHabilidad("ataque"))+" puntos de prioridad");
            }
        } else if (carta instanceof Profesor) {
            ((Profesor )carta).activar(pc);
            view.setUltimaAccion("PC obtiene carta Profesor, pierde "+String.valueOf(((Profesor )carta).getPuntosHabilidad()+ " puntos de prioridad"));

        } else if (carta instanceof Carrete) {
            ((Carrete )carta).activar(pc);
            view.setUltimaAccion("PC obtiene carta Carrete, recupera "+String.valueOf(((Carrete )carta).getPuntosHabilidad())+ " puntos de prioridad");
        }
    }

    public void asignarCartas(Sansano jugador, Sansano pc) {
        Globales.asignarRandom(jugador);
        if(this.ModoJuego == 0){
            Agresivo(pc);
        }
        else if(this.ModoJuego == 1){
            Defensivo(pc);
        }
    }

    private void giveCartasNormales(List<Carta> listaCartas){
        int i;
        for (Globales.Cards cartas : Globales.Cards.values()) {
            switch (cartas) {
                case MATE:
                    listaCartas.add(0, new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef()));
                    break;
                case FIS:
                    for (i = 0; i < 4; i++) {
                        listaCartas.add(0, new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef()));
                    }
                    break;
                case LP:
                    for (i = 0; i < 2; i++) {
                        listaCartas.add(0, new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef()));
                    }
                    break;
                case PROGRA:
                    for (i = 0; i < 6; i++) {
                        listaCartas.add(0, new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef()));
                    }
                    break;
                case ED:
                    for (i = 0; i < 3; i++) {
                        listaCartas.add(0, new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef()));
                    }
                    break;
                case EDD:
                    for (i = 0; i < 4; i++) {
                        listaCartas.add(0, new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef()));
                    }
                    break;
            }
        }
    }

    private void giveCartasEspecialesRandom(List<Carta> listaCartas){
        int rand, i;
        i = 20;
        for (Globales.Cards cartas : Globales.Cards.values()) {
            switch (cartas) {
                case BAH:
                case MA:
                case CIF:
                case MR:

                    rand = ThreadLocalRandom.current().nextInt(0, i++);
                    listaCartas.add(rand, new Profesor(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos()));
                    break;
                case CERR:
                case INTER:
                case FONDA:
                case WEEK:
                case FREE:
                case OMBLIGO:

                    rand = ThreadLocalRandom.current().nextInt(0, i++);
                    listaCartas.add(rand, new Carrete(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos()));
            }

        }


    }
    private void Defensivo(Sansano pc){
        // Insertar cartas jugador
        List<Carta> listaCartas = new ArrayList<>(30);
        giveCartasNormales(listaCartas);
        listaCartas.sort((a, b) -> ((Curso) a).getDefensa() > ((Curso) b).getDefensa() ? -1 :
                (((Curso) a).getDefensa() < ((Curso) b).getDefensa()) ? 1 : 0);

        giveCartasEspecialesRandom(listaCartas);
        for (Object listaCarta : listaCartas) {
            pc.addCard((Carta) listaCarta);
        }
    }
    private void Agresivo(Sansano pc){
        // Insertar cartas jugador
        List<Carta> listaCartas = new ArrayList<>(30);
        giveCartasNormales(listaCartas);
        listaCartas.sort((a, b) -> ((Curso) a).getAtaque() > ((Curso) b).getAtaque() ? -1 :
                (((Curso) a).getAtaque() < ((Curso) b).getAtaque()) ? 1 : 0);
        giveCartasEspecialesRandom(listaCartas);
        for (Object listaCarta : listaCartas) {
            pc.addCard((Carta) listaCarta);
        }
    }
}