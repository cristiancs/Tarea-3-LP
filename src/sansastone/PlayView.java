package sansastone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Cristian Navarrete on 27-09-16.
 */
public class PlayView extends JFrame {

    private JButton atacarButton;

/******** Funcion: getAtacarButton ********************
Descripcion: obtiene el boton para atacar
Parametros:
None
Retorno: JButton
************************************************/
    public JButton getAtacarButton() {
        return atacarButton;
    }

/******** Funcion: getDefendermeButton ********************
Descripcion: obtiene el boton para defenderse
Parametros:
None
Retorno: JButton
************************************************/
    public JButton getDefendermeButton() {
        return defendermeButton;
    }

    private JButton defendermeButton;
    private JLabel prioridadUsuario;
    private JLabel CartaActual;
    private JLabel CardDescription;
    private JLabel prioridadEnemigo;
    private JLabel ultima_accion;
    private JLabel valorataque;
    private JLabel valordefensa;
    private JPanel panel;
    private JLabel NombreJugador;
    private JLabel NumeroTurno;
    private JLabel turnoJugadorLabel;
    private JLabel prioridadEnemigoLabel;

/******** Funcion: setCartaActual ********************
Descripcion: establece el texto de la carta actual
Parametros:
String texto
Retorno: void
************************************************/
    public void setCartaActual(String texto) {
        this.CartaActual.setText(texto);
    }

/******** Funcion: setCardDescription ********************
Descripcion: establece el texto que describe la carta
Parametros:
String texto
Retorno: void
************************************************/
    public void setCardDescription(String texto) {
        this.CardDescription.setText(texto);
    }

    /******** Funcion: setprioridadUsuario ********************
Descripcion: establece el texto de la prioridad del usuario
Parametros:
String texto
Retorno: void
************************************************/
    public void setprioridadUsuario(String texto) {
        this.prioridadUsuario.setText(texto);
    }

/******** Funcion: setprioridadUsuario ********************
Descripcion: establece el texto de la prioridad del contrincante
Parametros:
String texto
Retorno: void
************************************************/
    public void setprioridadEnemigo(String texto) {
        this.prioridadEnemigo.setText(texto);
    }

/******** Funcion: setprioridadUsuario ********************
Descripcion: establece el texto con la ultima jugada realizada
Parametros:
String texto
Retorno: void
************************************************/
    public void setUltimaAccion(String texto) {
        this.ultima_accion.setText(texto);
    }

/******** Funcion: setValorAtaque ********************
Descripcion: establece el texto del ataque de la carta actual
Parametros:
String texto
Retorno: void
************************************************/
    public void setValorAtaque(String texto) {
        this.valorataque.setText(texto);
    }

/******** Funcion: setValorAtaque ********************
Descripcion: establece el texto de la defensa de la carta actual
Parametros:
String texto
Retorno: void
************************************************/
    public void setValorDefensa(String texto) {
        this.valordefensa.setText(texto);
    }

/******** Funcion: setNombreJugador ********************
Descripcion: establece el texto con el nombre del jugador
Parametros:
String texto
Retorno: void
************************************************/
    public void setNombreJugador(String texto) {
        this.NombreJugador.setText(texto);
    }

/******** Funcion: setNumeroTurno ********************
Descripcion: establece el texto con el turno
Parametros:
String texto
Retorno: void
************************************************/
    public void setNumeroTurno(String texto) {
        this.NumeroTurno.setText(texto);
    }

/******** Funcion: setTurnoJugadorLabel ********************
Descripcion: establece el texto del turno sobre la etiqueta
Parametros:
String texto
Retorno: void
************************************************/
    public void setTurnoJugadorLabel(String texto) {
        this.turnoJugadorLabel.setText(texto);
    }

/******** Funcion: setPrioridadEnemigoLabel ********************
Descripcion: establece el texto de la prioridad del enemigo
sobre la etiqueta
Parametros:
String texto
Retorno: void
************************************************/
    public void setPrioridadEnemigoLabel(String texto) {
        this.prioridadEnemigoLabel.setText(texto);
    }

/******** Funcion: PlayView ********************
Descripcion: Constructor que establece la vista durante el
desarrollo del juego
Parametros:
None
************************************************/
    public PlayView() {
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */

/******** Funcion: $$$setupUI$$$ ********************
Descripcion: metodo para el funcionamiento fuera de intellij ide
Parametros:
None
Retorno: void
************************************************/
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 5, new Insets(20, 20, 20, 20), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Tu Prioridad :");
        panel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Nombre Carta:");
        panel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        defendermeButton = new JButton();
        defendermeButton.setText("Defenderme");
        panel.add(defendermeButton, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 2, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        CartaActual = new JLabel();
        CartaActual.setText("CARTANAME");
        panel.add(CartaActual, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        CardDescription = new JLabel();
        CardDescription.setText("Ataca 000/Cura 000 puntos de prioridad");
        panel.add(CardDescription, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("ATAQUE:");
        panel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("DEFENSA");
        panel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        prioridadUsuario = new JLabel();
        prioridadUsuario.setText("0000");
        panel.add(prioridadUsuario, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("SansaStone");
        panel.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        atacarButton = new JButton();
        atacarButton.setText("Atacar");
        panel.add(atacarButton, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Descripcion:");
        panel.add(label6, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        prioridadEnemigoLabel = new JLabel();
        prioridadEnemigoLabel.setText("Prioridad Enemigo:");
        panel.add(prioridadEnemigoLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        prioridadEnemigo = new JLabel();
        prioridadEnemigo.setText("0000");
        panel.add(prioridadEnemigo, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Ultima Jugada:");
        panel.add(label7, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ultima_accion = new JLabel();
        ultima_accion.setText("EL NOMBRE DEL USUARIO 1 ATACA AL NOMBRE DEL USUARIO 2 CON 10000 PUNTOS DE PRIORIDAD.");
        panel.add(ultima_accion, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        valorataque = new JLabel();
        valorataque.setText("000");
        panel.add(valorataque, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        valordefensa = new JLabel();
        valordefensa.setText("000");
        panel.add(valordefensa, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        turnoJugadorLabel = new JLabel();
        turnoJugadorLabel.setText("Bienvenido Jugador");
        panel.add(turnoJugadorLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        NombreJugador = new JLabel();
        NombreJugador.setText("NOMBREJUGADOR");
        panel.add(NombreJugador, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Turno:");
        panel.add(label8, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        NumeroTurno = new JLabel();
        NumeroTurno.setText("0");
        panel.add(NumeroTurno, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */

/******** Funcion: $$$getRootComponent$$$ ********************
Descripcion: metodo para el funcionamiento fuera de intellij ide
Parametros:
None
Retorno: JComponent
************************************************/
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}
