public abstract class Carta {

    protected String nombre;
    protected String descripcion;
    protected int puntosHabilidad;
    protected String tipo;

    public abstract int activar(Sansano jugador);

    public int getPuntosHabilidad (){ return puntosHabilidad; }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
