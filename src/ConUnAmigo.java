import javax.swing.*;

public class ConUnAmigo implements ModoJuego {

    public void iniciar(ModoJuegoView oldScreen) {
        oldScreen.setVisible(false);
        PlayView view = new PlayView();
        String nombreJugador1 = null;
        String nombreJugador2 = null;
        while ((nombreJugador1 == null) || nombreJugador1.isEmpty()) {
            nombreJugador1 = JOptionPane.showInputDialog(view, "Introduzca nombre Jugador 1:");

        }
        while ((nombreJugador2 == null) || nombreJugador2.isEmpty()) {
            nombreJugador2 = JOptionPane.showInputDialog(view, "Introduzca nombre Jugador 2:");

        }
        view.setTurnoJugadorLabel("Turno del jugador:");
        view.setNombreJugador(nombreJugador1);
    }

    public void asignarCartas(Sansano jugador, Sansano contrincante, int opcion) {
        Globales global = new Globales();
        global.asignarRandom(jugador);
        global.asignarRandom(contrincante);
    }
}
