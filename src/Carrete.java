public class Carrete extends Carta {

    protected int curacion;

    public Carrete (String name, String descript, int heal) {
        nombre = name;
        descripcion = descript;
        tipo = "carrete";
        curacion = puntosHabilidad = heal;
    }

    public int activar(Sansano jugador) {
        jugador.updatePrioridad(curacion);
        return jugador.getPrioridad();
    }
}