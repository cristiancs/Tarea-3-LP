package sansastone;

public interface ModoJuego {

/******** Funcion: asignarCartas ********************
Descripcion: asigna la cartas a ambos jugadores utilizando 
distintas metodologías
Parametros:
Sansano jugador
Sansano contrincante
Retorno: void
************************************************/
    void asignarCartas(Sansano jugador, Sansano contrincante);

/******** Funcion: iniciar ********************
Descripcion: inicializa parámetros de la partida y asigna mazos según
modalidad
Parametros:
ModoJuegoView modoJuegoView
Sansano s1
Sansano s2
Retorno: void
************************************************/
    void iniciar(ModoJuegoView modoJuegoView, Sansano s1, Sansano s2);

/******** Funcion: DesarrolloJuego ********************
Descripcion: Desarrolla una ronda de la partida dependiendo de la modalidad
Parametros:
None
Retorno: void
************************************************/
    void DesarrolloJuego ();
}
