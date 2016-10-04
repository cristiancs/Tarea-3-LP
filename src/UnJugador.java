import javax.swing.*;

/**
 * Created by Cristian Navarrete on 27-09-16.
 */
public class UnJugador implements ModoJuego{
    public void init (ModoJuegoView oldScreen) {
        oldScreen.setVisible(false);
        PlayView view = new PlayView();
        String nombre = null;
        while ((nombre == null) || nombre.isEmpty()) {
            nombre = JOptionPane.showInputDialog(view, "Introduzca su nombre:");

        }
        String[] opciones = {"Modo Agresivo", "Modo Pasivo"};
        int opcion = -1;
            while (opcion == -1) {
            opcion = JOptionPane.showOptionDialog(
                    null                             //componente
                    , "Elija un Modo de Juego"            // Mensaje
                    , "Opciones Personalizada"         // Titulo en la barra del cuadro
                    , JOptionPane.DEFAULT_OPTION       // Tipo de opciones
                    , JOptionPane.INFORMATION_MESSAGE  // Tipo de mensaje (icono)
                    , null                             // Icono (ninguno)
                    , opciones                         // Opciones personalizadas
                    , null                             // Opcion por defecto
            );
        }
        view.setNombreJugador(nombre);

    }

    public void asignarCartas(Sansano jugador, Sansano pc) {

        // Insertar cartas jugador
        /*for (Object cartas : Globales.Cards.values()){
            Carta toAdd = new Carta(cartas.getName(), cartas.getDescripcion(), cartas.getPuntos());
            switch (Cards){
            }

        }*/

    }
}
