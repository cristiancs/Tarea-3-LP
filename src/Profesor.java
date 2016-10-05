public class Profesor extends Carta {

    public int getDanio() {
        return danio;
    }
    public int puntosHabilidad(String modo){
        return danio;
    }

    protected int danio;
    public Profesor (String name, String descript, int damage) {
        nombre = name;
        descripcion = descript;
        danio = damage;
        tipo = "profesor";
    }


    public int activar(Sansano jugador, String modo) {
        puntosHabilidad = -danio;
        jugador.updatePrioridad(puntosHabilidad);
        return jugador.getPrioridad();
    }

}
