import java.util.Objects;
public abstract class Carta {

    protected String nombre;
    protected String descripcion;
    protected int puntosHabilidad;
    protected String tipo;

    public abstract int activar(Sansano jugador, String modo);
    public abstract int puntosHabilidad(String modo);

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
