public class Carrete extends Carta {

    public int getCuracion() {
        return curacion;
    }
    public int puntosHabilidad(String modo){
        return curacion;
    }
    protected int curacion;

    public Carrete (String name, String descript, int heal) {
        nombre = name;
        descripcion = descript;
        tipo = "carrete";
        curacion = puntosHabilidad = heal;
    }

    public int activar(Sansano jugador, String modo) {
        jugador.updatePrioridad(curacion);
        return jugador.getPrioridad();
    }
}