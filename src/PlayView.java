import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Cristian Navarrete on 27-09-16.
 */
public class PlayView extends JFrame{
    private JButton atacarButton;
    private JButton defendermeButton;
    private JLabel prioridadUsuario;
    private JLabel CartaActual;
    private JLabel prioridadEnemigo;
    private JLabel ultima_accion;
    private JLabel valorataque;
    private JLabel valordefensa;
    private JPanel panel;
    private JLabel NombreJugador;
    private JLabel NumeroTurno;
    private JLabel turnoJugadorLabel;
    private JLabel prioridadEnemigoLabel;


    public void setCartaActual(String texto){
        this.CartaActual.setText(texto);
    }
    public void setprioridadUsuario(String texto){
        this.prioridadUsuario.setText(texto);
    }
    public void setprioridadEnemigo(String texto){
        this.prioridadEnemigo.setText(texto);
    }
    public void setultima_accion(String texto){
        this.ultima_accion.setText(texto);
    }
    public void setvalorataque(String texto){
        this.valorataque.setText(texto);
    }
    public void setvalordefensa(String texto){
        this.valordefensa.setText(texto);
    }
    public void setNombreJugador(String texto){
        this.NombreJugador.setText(texto);
    }
    public void setNumeroTurno(String texto){
        this.NumeroTurno.setText(texto);
    }
    public void setturnoJugadorLabel(String texto){
        this.turnoJugadorLabel.setText(texto);
    }
    public void setprioridadEnemigoLabel(String texto){
        this.prioridadEnemigoLabel.setText(texto);
    }




    public PlayView() {
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        atacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(PlayView.this, "Atacar");
            }
        });
        defendermeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(PlayView.this, "Defenderme");
            }
        });
        setVisible(true);

    }
}
