public class Curso extends Carta {

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getPuntosHabilidad(){
            return defensa;
    }

    public int getPuntosHabilidad(String modo){
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
        ataque  = atq;
        defensa = def;
        tipo = "curso";
    }

    private void Aprobar (Sansano jugador) {
        puntosHabilidad = defensa;
        jugador.updatePrioridad(puntosHabilidad);
    }

    private void Reprobar (Sansano jugador) {
        puntosHabilidad = -ataque;
        jugador.updatePrioridad(puntosHabilidad);
    }

    public void activar(Sansano jugador){
        if(Globales.getModoUso().equals("ataque") ){
            Reprobar(jugador);
        }
        else{
            Aprobar(jugador);
        }
    }
}
