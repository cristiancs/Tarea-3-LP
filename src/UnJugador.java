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

    public void asignarCartas(Sansano jugador, Sansano pc) {

        // Insertar Cursos
        for (int i = 0; i < 1; i++) {
            jugador.addCard(Globales.mate);
            pc.addCard(Globales.mate);
        }
        for (int i = 0; i < 4; i++) {
            jugador.addCard(Globales.fis);
            pc.addCard(Globales.fis);
        }
        for (int i = 0; i < 2; i++) {
            jugador.addCard(Globales.lp);
            pc.addCard(Globales.lp);
        }
        for (int i = 0; i < 6; i++) {
            jugador.addCard(Globales.progra);
            pc.addCard(Globales.progra);
        }
        for (int i = 0; i < 3; i++) {
            jugador.addCard(Globales.ed);
            pc.addCard(Globales.ed);
        }
        for (int i = 0; i < 4; i++) {
            jugador.addCard(Globales.edd);
            pc.addCard(Globales.edd);
        }

        // Insertar Profesores
        jugador.addCard(Globales.bah);
        pc.addCard(Globales.bah);

        jugador.addCard(Globales.ma);
        pc.addCard(Globales.ma);

        jugador.addCard(Globales.cif);
        pc.addCard(Globales.cif);

        jugador.addCard(Globales.mr);
        pc.addCard(Globales.mr);

        // Insertar Carretes
        jugador.addCard(Globales.cerr);
        pc.addCard(Globales.cerr);

        jugador.addCard(Globales.inter);
        pc.addCard(Globales.inter);

        jugador.addCard(Globales.fonda);
        pc.addCard(Globales.fonda);

        jugador.addCard(Globales.semana);
        pc.addCard(Globales.semana);

        jugador.addCard(Globales.libre);
        pc.addCard(Globales.libre);

        jugador.addCard(Globales.ombligo);
        pc.addCard(Globales.ombligo);

    }
}
