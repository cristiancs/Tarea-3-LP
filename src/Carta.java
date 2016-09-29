import java.util.Objects;
public abstract class Carta {

    protected String nombre;
    protected String descripcion;
    protected int puntosHabilidad;

    protected void activar(Sansano jugador) {
        jugador.updatePrioridad(puntosHabilidad);
    }

    protected void activar (Sansano jugador, int puntos, String modo) {
        if (Objects.equals(modo, "ataque")){
            jugador.updatePrioridad(-puntos);
        }
    }
}
