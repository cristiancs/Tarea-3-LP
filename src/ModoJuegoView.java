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

    public ModoJuegoView() {
        setContentPane(Portada);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a1JugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                UnJugador juego = new UnJugador(ModoJuegoView.this);
            }
        });
        a2JugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DosJugadores juego = new DosJugadores(ModoJuegoView.this);
            }
        });
        setVisible(true);

    }

}
