package sansastone;

import javax.swing.*;
public class ConUnAmigo extends Globales implements ModoJuego {

    private Sansano j1, j2;
    private PlayView view;
    private Duelo juego;
    private Object carta;

/******** Funcion: iniciar ********************
Descripcion: Establece parametros iniciales del juego con dos jugadores, tales como:
actualizar ventana, asignar cartas a mazos, obtener nombres, etc
Parametros:
ModoJuegoView oldScreen
Sansano s1
Sansano s2
Retorno: void
************************************************/
    public void iniciar(ModoJuegoView oldScreen, Sansano s1, Sansano s2) {
        Globales.setmodoJuego("conunamigo");
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
        view.setUltimaAccion("");
        asignarCartas(j1, j2);
        juego = new Duelo();
    }

/******** Funcion: asignarCartas ********************
Descripcion: asigna las cartas a ambos jugadores usando azar en ambos casos
Parametros:
Sansano jugador
Sansano contrincante
Retorno: void
************************************************/
    public void asignarCartas(Sansano jugador, Sansano contrincante) {
        asignarRandom(jugador);
        asignarRandom(contrincante);
    }

/******** Funcion: DesarrolloJuego ********************
Descripcion: hace el desarrollo del juego en todos los turnos,
actualizando variables correspondientes en Sansanos y la ventana
Parametros:
None
Retorno: void
************************************************/
    public void DesarrolloJuego (){
        JButton atacarButton = view.getAtacarButton();
        JButton defendermeButton = view.getDefendermeButton();
        carta = null;

        atacarButton.addActionListener(e -> {
            Globales.setModoUso("ataque");
            if (carta != null) {
                if(juego.getTurno() % 2 == 0){
                    ((Curso) carta).activar(j1, view);
                }
                else{
                    ((Curso) carta).activar(j2, view);
                }
            }
            carta = DesarrolloJugada(juego, view, j1, j2);
        });

        defendermeButton.addActionListener(e -> {
            Globales.setModoUso("defensa");
            if(juego.getTurno() % 2 == 0){
                ((Carta) carta).activar(j2, view);
            }
            else{
                ((Carta) carta).activar(j1, view);
            }
            carta = DesarrolloJugada(juego, view, j1, j2);
        });
        carta = DesarrolloJugada(juego, view, j1, j2);

    }
}
