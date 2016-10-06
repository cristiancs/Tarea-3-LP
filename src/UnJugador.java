import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Cristian Navarrete on 27-09-16.
 */
public class UnJugador implements ModoJuego{
    private Sansano pc,jugador;
    private PlayView view;
    private Duelo juego;
    private int cache;
    private Object carta;
    private JButton atacarButton;
    private JButton defendermeButton;

    public void iniciar(ModoJuegoView oldScreen) {
        oldScreen.setVisible(false);
        view = new PlayView();
        pc = new Sansano();
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
        jugador = new Sansano(nombre);
        view.setNombreJugador(nombre);

        view.setprioridadEnemigo("3000");
        view.setprioridadUsuario("3000");
        view.setNumeroTurno("1");
        view.setUltimaAccion("");
        asignarCartas(jugador, pc, opcion);

        juego = new Duelo();
        atacarButton = view.getAtacarButton();
        defendermeButton = view.getDefendermeButton();
        carta = null;
        view.getAtacarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cache = ((Carta) carta).activar(jugador, "ataque");
                view.setprioridadEnemigo(String.valueOf(cache));
                juegoBot();
                DesarrolloJuego(juego);
            }
        });
        defendermeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(carta instanceof Curso){
                    cache = ((Curso) carta).activar(jugador, "defensa");
                } else if (carta instanceof Profesor) {
                    cache = ((Profesor) carta).activar(jugador, "defensa");
                } else if (carta instanceof Carrete) {
                    cache = ((Carrete) carta).activar(jugador, "defensa");
                }
                view.setprioridadUsuario(String.valueOf(cache));
                juegoBot();
                DesarrolloJuego(juego);
            }
        });
        DesarrolloJuego(juego);
    }
    private void DesarrolloJuego(Duelo juego){
        if(juego.getTurno() <= 60 && juego.getGanador().equals("")) {
            carta = jugador.getCard();
            view.setCartaActual(((Carta) carta).getNombre());

            if (carta instanceof Curso) {
                defendermeButton.setText("Defenderme");
                atacarButton.setEnabled(true);
                defendermeButton.setEnabled(true);
                view.setValorAtaque(String.valueOf(((Curso) carta).getAtaque()));
                view.setValorDefensa(String.valueOf(((Curso) carta).getDefensa()));
            } else if (carta instanceof Profesor) {
                atacarButton.setEnabled(false);
                defendermeButton.setEnabled(true);
                defendermeButton.setText("Utilizar Carta");

                view.setValorAtaque(String.valueOf(((Profesor) carta).getDanio()));
                view.setValorDefensa(" ");
            } else if (carta instanceof Carrete) {
                atacarButton.setEnabled(false);
                defendermeButton.setEnabled(true);
                defendermeButton.setText("Utilizar Carta");
                view.setValorDefensa(String.valueOf(((Carrete) carta).getCuracion()));
                view.setValorAtaque(" ");

            }

            if (jugador.getPrioridad() == 0) {
                juego.setGanador(jugador.getName());
                view.setVisible(false);
            }
            if (pc.getPrioridad() == 0) {
                juego.setGanador(pc.getName());
                view.setVisible(false);
            }
            juego.setTurno(juego.getTurno() + 1);
            view.setNumeroTurno(String.valueOf(juego.getTurno()));
        }
        else {
            if (jugador.getPrioridad() >  pc.getPrioridad()) {
                juego.setGanador(jugador.getName());
                view.setVisible(false);
            }
            else if(jugador.getPrioridad() < pc.getPrioridad()) {
                juego.setGanador(pc.getName());
                view.setVisible(false);
            }
            else {
                juego.setGanador("EMPATE");
                view.setVisible(false);
            }
        }
    }
    private void juegoBot(){
        Object carta = this.pc.getCard();
        if (carta instanceof Curso) {
            int rand = ThreadLocalRandom.current().nextInt(0, 2);
            if(rand == 1){
                cache = ((Curso )carta).activar(pc, "defensa");
                view.setprioridadEnemigo(String.valueOf(cache));
                view.setUltimaAccion("PC se defiende, obtiene "+String.valueOf(((Curso )carta).puntosHabilidad("defensa"))+ " puntos de prioridad");
            }
            else{
                cache = ((Carta )carta).activar(jugador, "ataque");
                view.setprioridadUsuario(String.valueOf(cache));
                view.setUltimaAccion("PC ataca con "+String.valueOf(((Carta )carta).puntosHabilidad("ataque"))+" puntos de prioridad");
            }
        } else if (carta instanceof Profesor) {
            cache = ((Profesor )carta).activar(pc, "ataque");
            view.setprioridadEnemigo(String.valueOf(cache));
            view.setUltimaAccion("PC obtiene carta Profesor, pierde "+String.valueOf(((Profesor )carta).puntosHabilidad("defensa"))+ " puntos de prioridad");

        } else if (carta instanceof Carrete) {
            cache = ((Carrete )carta).activar(pc, "defensa");
            view.setprioridadEnemigo(String.valueOf(cache));
            view.setUltimaAccion("PC obtiene carta Profesor, pierde "+String.valueOf(((Carrete )carta).puntosHabilidad("defensa"))+ " puntos de prioridad");
        }
        juego.setTurno(juego.getTurno()+1);
        view.setNumeroTurno(String.valueOf(juego.getTurno()));
    }

    public void asignarCartas(Sansano jugador, Sansano pc,int opcion) {
        Globales global = new Globales();
        global.asignarRandom(jugador);
        if(opcion == 0){
            Agresivo(pc);
        }
        else if(opcion == 1){
            Defensivo(pc);
        }
    }

    private void giveCartasNormales(List listaCartas){
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
    private void giveCartasEspecialesRandom(List listaCartas){
        int rand, i, i2;
        i2 = 20;
        for (Globales.Cards cartas : Globales.Cards.values()) {
            switch (cartas) {
                case BAH:
                case MA:
                case CIF:
                case MR:

                    rand = ThreadLocalRandom.current().nextInt(0, i2);
                    listaCartas.add(rand, new Profesor(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos()));
                    i2++;
                    break;
                case CERR:
                case INTER:
                case FONDA:
                case WEEK:
                case FREE:
                case OMBLIGO:

                    rand = ThreadLocalRandom.current().nextInt(0, i2);
                    listaCartas.add(rand, new Carrete(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos()));
                    i2++;
            }

        }


    }
    private void Defensivo(Sansano pc){
        // Insertar cartas jugador
        List listaCartas = new ArrayList<Carta>(30);
        giveCartasNormales(listaCartas);
        Collections.sort(listaCartas, new Comparator<Curso>() {
            @Override
            public int compare(Curso a, Curso b) {
                return a.getDefensa() > b.getDefensa() ? -1 : (a.getDefensa() < b.getDefensa()) ? 1 : 0;
            }
        });

        giveCartasEspecialesRandom(listaCartas);
        for (Object listaCarta : listaCartas) {
            pc.addCard((Carta) listaCarta);
        }
    }
    private void Agresivo(Sansano pc){
        // Insertar cartas jugador
        List listaCartas = new ArrayList(30);
        giveCartasNormales(listaCartas);
        Collections.sort(listaCartas, new Comparator<Curso>() {
            @Override
            public int compare(Curso a, Curso b) {
                return a.getAtaque() > b.getAtaque() ? -1 : (a.getAtaque() < b.getAtaque()) ? 1 : 0;
            }
        });

        giveCartasEspecialesRandom(listaCartas);
        for (Object listaCarta : listaCartas) {
            pc.addCard((Carta) listaCarta);
        }
    }
}