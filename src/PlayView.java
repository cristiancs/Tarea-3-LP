import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Cristian Navarrete on 27-09-16.
 */
public class PlayView extends JFrame{
    private JButton atacarButton;

    public JButton getAtacarButton() {
        return atacarButton;
    }

    public JButton getDefendermeButton() {
        return defendermeButton;
    }

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
    public void setUltimaAccion(String texto){
        this.ultima_accion.setText(texto);
    }
    public void setValorAtaque(String texto){
        this.valorataque.setText(texto);
    }
    public void setValorDefensa(String texto){
        this.valordefensa.setText(texto);
    }
    public void setNombreJugador(String texto){
        this.NombreJugador.setText(texto);
    }
    public void setNumeroTurno(String texto){
        this.NumeroTurno.setText(texto);
    }
    public void setTurnoJugadorLabel(String texto){
        this.turnoJugadorLabel.setText(texto);
    }
    public void setPrioridadEnemigoLabel(String texto){
        this.prioridadEnemigoLabel.setText(texto);
    }




    public PlayView() {
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
