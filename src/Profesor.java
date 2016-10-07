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

    private void Recorregir (Sansano jugador){
        jugador.updatePrioridad(-danio);
    }
}
