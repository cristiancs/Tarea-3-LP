public class Profesor extends Carta {

    protected int daño;

    public Profesor (String name, String descript, int damage) {
        nombre = name;
        descripcion = descript;
        daño = damage;
    }

    public void activar(Sansano jugador) {
        puntosHabilidad = -daño;
        super.activar(jugador);
    }

}
