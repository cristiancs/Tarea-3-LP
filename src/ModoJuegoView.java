import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Cristian Navarrete on 27-09-16.
 */
public class ModoJuegoView extends JFrame{

    private JButton a1JugadorButton;
    private JButton a2JugadoresButton;
    private JPanel Portada;

    public ModoJuegoView (Sansano s1, Sansano s2) {
        setContentPane(Portada);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a1JugadorButton.addActionListener(e -> {
            ModoJuego juego = new UnJugador();
            juego.iniciar(ModoJuegoView.this,s1,s2);
            juego.DesarrolloJuego();
        });
        a2JugadoresButton.addActionListener(e -> {
            ModoJuego juego = new ConUnAmigo();
            juego.iniciar(ModoJuegoView.this,s1,s2);
            juego.DesarrolloJuego();

        });
        setVisible(true);
    }
}
