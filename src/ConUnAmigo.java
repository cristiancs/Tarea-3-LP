import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConUnAmigo extends Globales implements ModoJuego {

    private Sansano j1, j2;
    private PlayView view;
    private Duelo juego;
    private Object carta;

    public void iniciar(ModoJuegoView oldScreen, Sansano s1, Sansano s2) {

        oldScreen.setVisible(false);
        view = new PlayView();
        String nombreJugador1 = null;
        String nombreJugador2 = null;
        j1 = s1;
        j2 = s2;
        while ((nombreJugador1 == null) || nombreJugador1.isEmpty()) {
            nombreJugador1 = JOptionPane.showInputDialog(view, "Introduzca nombre Jugador 1:");

        }
        while ((nombreJugador2 == null) || nombreJugador2.isEmpty()) {
            nombreJugador2 = JOptionPane.showInputDialog(view, "Introduzca nombre Jugador 2:");

        }
        s1.setName(nombreJugador1);
        s2.setName(nombreJugador2);
        view.setTurnoJugadorLabel("Turno del jugador:");
        view.setNombreJugador(nombreJugador1);
        asignarCartas(j1, j2);
        juego = new Duelo();
    }

    public void asignarCartas(Sansano jugador, Sansano contrincante) {
        asignarRandom(jugador);
        asignarRandom(contrincante);
    }

    public void DesarrolloJuego (){
        JButton atacarButton = view.getAtacarButton();
        JButton defendermeButton = view.getDefendermeButton();
        carta = null;

        atacarButton.addActionListener(e -> {
            Globales.setModoUso("ataque");
            if (carta != null) {
                ((Curso) carta).activar(j2, view);
            }
            carta = DesarrolloJugada(juego, view, j1, j2);
        });

        defendermeButton.addActionListener(e -> {
            Globales.setModoUso("defensa");
            ((Carta)carta).activar(j1, view);



            carta = DesarrolloJugada(juego, view, j1, j2);
        });
        carta = DesarrolloJugada(juego, view, j2, j1);

    }
}
