import javax.swing.*;

/**
 * Created by Cristian Navarrete on 05-10-16.
 */
public class GanadorView extends JFrame{
    private JLabel ganadorText;
    private JPanel panel;

    public void setGanadorText(String texto){
        this.ganadorText.setText(texto);
    }

    public GanadorView() {
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
