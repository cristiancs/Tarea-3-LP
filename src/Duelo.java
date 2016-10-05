public class Duelo {
    private int turno;
    private String ganador;
    public Duelo(){
        turno = 0;
        ganador = "";
    }
    public int getTurno() {return turno;}
    public void setTurno(int turno) {
        this.turno = turno;
    }
    public String getGanador() {
        return ganador;
    }
    public void setGanador(String ganador) {
        this.ganador = ganador;
        GanadorView view = new GanadorView();
        if(!ganador.equals("EMPATE")){
            view.setGanadorText("Gana el Jugador \""+ganador+"\"");
        }
        else{
            view.setGanadorText("Los Jugadores Empatan");
        }
    }


}
