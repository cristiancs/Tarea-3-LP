public class Carrete extends Carta {

    protected int curacion;

    public Carrete (String name, String descript, int heal) {
        nombre = name;
        descripcion = descript;
        tipo = "carrete";
        curacion = puntosHabilidad = heal;
    }

    public void activar(Sansano jugador) {
        Carretear(jugador);
    }
    public void activar(Sansano jugador, PlayView view) {
        Carretear(jugador);
        view.setUltimaAccion(jugador.getName()+" obtiene carta Carrete, recupera "+String.valueOf(curacion)+ " puntos de prioridad");
    }

    private void Carretear(Sansano jugador) {
        jugador.updatePrioridad(curacion);
    }
}