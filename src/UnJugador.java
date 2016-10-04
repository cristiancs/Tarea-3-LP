import javax.swing.*;
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
    private Sansano pc = new Sansano();
    private Sansano jugador;
    public void init (ModoJuegoView oldScreen) {
        oldScreen.setVisible(false);
        PlayView view = new PlayView();
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
        if(opcion == 0){
            Agresivo();
        }
        else if(opcion == 1){
            Defensivo();
        }

    }

    public void asignarCartas(Sansano jugador, Sansano pc) {
        int rand, i;
        Carta carta;
        Globales global = new Globales();
        List<Integer> posiciones = new ArrayList<>();
        for (Globales.Cards cartas : Globales.Cards.values()) {
            switch (cartas) {
                case MATE:
                    rand = global.randomMazo(posiciones);
                    carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                    jugador.addCard(carta, rand);
                    break;
                case FIS:
                    for (i = 0; i < 4; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case LP:
                    for (i = 0; i < 2; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case PROGRA:
                    for (i = 0; i < 6; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case ED:
                    for (i = 0; i < 3; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case EDD:
                    for (i = 0; i < 4; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case BAH:
                case MA:
                case CIF:
                case MR:
                    rand = global.randomMazo(posiciones);
                    carta = new Profesor(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos());
                    jugador.addCard(carta, rand);
                    break;
                case CERR:
                case INTER:
                case FONDA:
                case WEEK:
                case FREE:
                case OMBLIGO:
                    rand = global.randomMazo(posiciones);
                    carta = new Carrete(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos());
                    jugador.addCard(carta, rand);

            }
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
        Globales global = new Globales();
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
    private void Defensivo(){
        // Insertar cartas jugador
        List listaCartas = new ArrayList(30);
        giveCartasNormales(listaCartas);
        Collections.sort(listaCartas, new Comparator<Curso>() {
            @Override
            public int compare(Curso a, Curso b) {
                return a.getDefensa() > b.getDefensa() ? -1 : (a.getDefensa() < b.getDefensa()) ? 1 : 0;
            }
        });

        giveCartasEspecialesRandom(listaCartas);
        for(int x=0;x<listaCartas.size();x++) {
            pc.addCard((Carta)listaCartas.get(x));
        }
    }
    private void Agresivo(){
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

    }
}