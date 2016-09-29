public class Carrete extends Carta {

    protected int curacion;

    public Carrete (String name, String descript, int heal) {
        nombre = name;
        descripcion = descript;
        curacion = puntosHabilidad = heal;
    }

    public void activar(Sansano jugador) {
        super.activar(jugador);
    }
}