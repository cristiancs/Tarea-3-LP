import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Cristian Navarrete on 27-09-16.
 */
public class UnJugador implements ModoJuego{
    public void init (ModoJuegoView oldScreen){
        oldScreen.setVisible(false);
        PlayView view = new PlayView();
        String nombre = null;
        while((nombre == null) || nombre.isEmpty()) {
            nombre = JOptionPane.showInputDialog(view, "Introduzca su nombre:");

        }
        view.setNombreJugador(nombre);

    }

    public void asignarCartas(Sansano jugador, Sansano pc) {

        /int rand = ThreadLocalRandom.current().nextInt(0, mazo.size() + 1);
        Object card = mazo.get(rand);
        mazo.remove(rand);*/

        // Insertar cartas jugador
        for (Globales.Cards cartas : Globales.Cards.values()){
            switch (cartas){
                case MATE:

                    break;
                case FIS:
            }

        }

    }
}
