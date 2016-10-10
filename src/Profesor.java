public class Profesor extends Carta {

    protected int danio;

    public Profesor (String name, String descript, int damage) {
        nombre = name;
        descripcion = descript;
        danio = puntosHabilidad = damage;
        tipo = "profesor";
    }

    public void activar(Sansano jugador) {
        Recorregir(jugador);
    }
    public void activar(Sansano jugador, PlayView view) {
        view.setUltimaAccion(jugador.getName()+" obtiene carta Carrete, pierde "+String.valueOf(danio)+ " puntos de prioridad");
        Recorregir(jugador);
    }


    private void Recorregir (Sansano jugador){
        jugador.updatePrioridad(-danio);
    }
}
