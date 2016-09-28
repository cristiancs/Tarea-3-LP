import javax.swing.*;

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
}
