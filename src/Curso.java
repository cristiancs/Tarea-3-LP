public class Curso extends Carta {

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }
    public int puntosHabilidad(String modo){
        if(modo.equals("ataque")){
            return ataque;
        }
        if(modo.equals("defensa")){
            return defensa;
        }
        return -1;
    }

    protected int ataque, defensa;


    public Curso (String name, String descript, int atq, int def) {
        nombre = name;
        descripcion = descript;
        ataque = atq;
        defensa = def;
        tipo = "curso";
    }

    public void Aprobar (Sansano jugador) {
        puntosHabilidad = defensa;
        jugador.updatePrioridad(puntosHabilidad);
    }

    public void Reprobar (Sansano jugador) {
        puntosHabilidad = -ataque;
        jugador.updatePrioridad(puntosHabilidad);
    }
    public int activar(Sansano jugador, String modo){
        if(modo.equals("ataque")){
            Reprobar(jugador);
        }
        else{
            Aprobar(jugador);
        }
        return jugador.getPrioridad();
    }
}
