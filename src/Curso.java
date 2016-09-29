public class Curso extends Carta {

    protected int ataque, defensa;


    public Curso (String name, String descript, int atq, int def) {
        nombre = name;
        descripcion = descript;
        ataque = atq;
        defensa = def;
    }

    public void Aprobar (Sansano jugador) {
        puntosHabilidad = defensa;
        activar(jugador);
    }

    public void Reprobar (Sansano jugador) {
        puntosHabilidad = -ataque;
        activar(jugador);
    }
}
