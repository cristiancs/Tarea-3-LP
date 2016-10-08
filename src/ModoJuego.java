
/**
 * Created by Cristian Navarrete on 27-09-16.
 */
public interface ModoJuego {
    void asignarCartas(Sansano jugador, Sansano contrincante);
    void iniciar(ModoJuegoView modoJuegoView, Sansano s1, Sansano s2);
    void DesarrolloJuego ();
}
