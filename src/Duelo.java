public class Duelo {

    static private int turno;
    private String ganador;

/******** Funcion: Duelo ********************
Descripcion: Constructor de Duelo, inicializando el turno inicial
y el ganador
Parametros:
None
************************************************/
    public Duelo(){
        turno = 0;
        ganador = "";
    }

/******** Funcion: getTurno ********************
Descripcion: Obtiene el turno actual
Parametros:
None
Retorno: int del del turno actual
************************************************/
    public int getTurno() {return turno;}

/******** Funcion: advanceTurno ********************
Descripcion: Avanza al siguiente turno de juego
Parametros:
None
Retorno: void
************************************************/
    public void advanceTurno() {
        Duelo.turno += 1;
    }

/******** Funcion: getGanador ********************
Descripcion: Obtiene el nombre del ganador
Parametros:
None
Retorno: String con el nombre del ganador
************************************************/
    public String getGanador() {
        return ganador;
    }

/******** Funcion: setGanador ********************
Descripcion: Establece el ganador y almacena su nombre
Parametros:
String ganador
Retorno: void
************************************************/
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
