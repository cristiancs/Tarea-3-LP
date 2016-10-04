import javax.swing.*;

public class ConUnAmigo implements ModoJuego{
    public void iniciar(ModoJuegoView oldScreen){
        oldScreen.setVisible(false);
        PlayView view = new PlayView();
        String nombreJugador1 = null;
        String nombreJugador2 = null;
        while((nombreJugador1 == null) || nombreJugador1.isEmpty()) {
            nombreJugador1 = JOptionPane.showInputDialog(view, "Introduzca nombre Jugador 1:");

        }
        while((nombreJugador2 == null) || nombreJugador2.isEmpty()) {
            nombreJugador2 = JOptionPane.showInputDialog(view, "Introduzca nombre Jugador 2:");

        }
        view.setturnoJugadorLabel("Turno del jugador:");
        view.setNombreJugador(nombreJugador1);


    }

    public void asignarCartas(Sansano jugador, Sansano jugador2, int opcion) {
        /*/ Insertar Cursos
        for (int i = 0; i < 1; i++) {
            jugador.addCard(Globales.mate);
            jugador2.addCard(Globales.mate);
        }
        for (int i = 0; i < 4; i++) {
            jugador.addCard(Globales.fis);
            jugador2.addCard(Globales.fis);
        }
        for (int i = 0; i < 2; i++) {
            jugador.addCard(Globales.lp);
            jugador2.addCard(Globales.lp);
        }
        for (int i = 0; i < 6; i++) {
            jugador.addCard(Globales.progra);
            jugador2.addCard(Globales.progra);
        }
        for (int i = 0; i < 3; i++) {
            jugador.addCard(Globales.ed);
            jugador2.addCard(Globales.ed);
        }
        for (int i = 0; i < 4; i++) {
            jugador.addCard(Globales.edd);
            jugador2.addCard(Globales.edd);
        }

        // Insertar Profesores
        jugador.addCard(Globales.bah);
        jugador2.addCard(Globales.bah);

        jugador.addCard(Globales.ma);
        jugador2.addCard(Globales.ma);

        jugador.addCard(Globales.cif);
        jugador2.addCard(Globales.cif);

        jugador.addCard(Globales.mr);
        jugador2.addCard(Globales.mr);

        // Insertar Carretes
        jugador.addCard(Globales.cerr);
        jugador2.addCard(Globales.cerr);

        jugador.addCard(Globales.inter);
        jugador2.addCard(Globales.inter);

        jugador.addCard(Globales.fonda);
        jugador2.addCard(Globales.fonda);

        jugador.addCard(Globales.semana);
        jugador2.addCard(Globales.semana);

        jugador.addCard(Globales.libre);
        jugador2.addCard(Globales.libre);

        jugador.addCard(Globales.ombligo);
        jugador2.addCard(Globales.ombligo);*/
    }
}
