import javax.swing.*;

/**
 * Created by Cristian Navarrete on 27-09-16.
 */
public class UnJugador implements ModoJuego{
    UnJugador(ModoJuegoView oldScreen){
        oldScreen.setVisible(false);
        UnJugadorView view = new UnJugadorView();
        String nombre = null;
        while((nombre == null) || nombre.isEmpty()) {
            nombre = JOptionPane.showInputDialog(view, "Introduzca su nombre:");

        }
        view.setNombreJugador(nombre);
        
    }
}
