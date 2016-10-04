import javax.swing.*;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian Navarrete on 27-09-16.
 */
public class UnJugador implements ModoJuego{
    public void init (ModoJuegoView oldScreen) {
        oldScreen.setVisible(false);
        PlayView view = new PlayView();
        String nombre = null;
        while ((nombre == null) || nombre.isEmpty()) {
            nombre = JOptionPane.showInputDialog(view, "Introduzca su nombre:");

        }
        String[] opciones = {"Modo Agresivo", "Modo Pasivo"};
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
        view.setNombreJugador(nombre);

    }

    public void asignarCartas(Sansano jugador, Sansano pc) {

        int rand, i;
        Globales global = new Globales;
        Carta carta;
        List<Integer> posiciones = new ArrayList<>();

        // Insertar cartas jugador
        for (Globales.Cards cartas : Globales.Cards.values()){
            switch (cartas){
                case MATE:
                    rand = global.randomMazo(posiciones);
                    carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                    jugador.addCard(carta, rand);
                    break;
                case FIS:
                    for (i = 0; i<4; i++){
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case LP:
                    for (i = 0; i<2; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case PROGRA:
                    for (i = 0; i<6; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case ED:
                    for (i = 0; i<3; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case EDD:
                    for (i = 0; i<4; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case BAH:case MA:case CIF:case MR:
                    rand = global.randomMazo(posiciones);
                    carta = new Profesor(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos());
                    jugador.addCard(carta, rand);
                            break;
                case CERR:case INTER:case FONDA:case WEEK:case FREE:case OMBLIGO:
                    rand = global.randomMazo(posiciones);
                    carta = new Profesor(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos());
                    jugador.addCard(carta, rand);

            }

        }

    }
}