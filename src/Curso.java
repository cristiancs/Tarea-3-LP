public class Curso extends Carta {

    protected int ataque, defensa;

/******** Funcion: Curso ********************
Descripcion: Constructor de la Carta tipo Curso, definiendo
nombre, descripcion, ataque, defensa y tipo
Parametros:
String name
String descript
int atq
int def
************************************************/
    public Curso (String name, String descript, int atq, int def) {
    nombre = name;
    descripcion = descript;
    ataque  = atq;
    defensa = def;
    tipo = "curso";
    }

/******** Funcion: getAtaque ********************
Descripcion: Obtiene el valor del Ataque de la Carta tipo Curso
Parametros:
None
Retorno: int del ataque de la Carta
************************************************/
    public int getAtaque() {
        return ataque;
    }

/******** Funcion: getDefensa ********************
Descripcion: Obtiene la defensa de la Carta tipo Curso
Parametros:
None
Retorno: int de la defensa de la Carta
************************************************/
    public int getDefensa() {
        return defensa;
    }

/******** Funcion: getPuntosHabilidad ********************
Descripcion: Obtiene los puntosHabilidad de la Carta que en este caso
por defecto representa simplemente la defensa
Parametros:
None
Retorno: resultado de la operacion aritmetica de la suma entero
************************************************/
    public int getPuntosHabilidad(){
            return defensa;
    }

/******** Funcion: getPuntosHabilidad ********************
Descripcion: Obtiene los puntosHabilidad de la Carta despendiendo del
modo que se requiera
Parametros:
String modo
Retorno: int del ataque o defensa según corresponda
************************************************/
    public int getPuntosHabilidad(String modo){
        if(modo.equals("ataque")){
            return ataque;
        }
        if(modo.equals("defensa")){
            return defensa;
        }
        return -1;
    }

/******** Funcion: Aprobar ********************
Descripcion: Actualiza la prioridad "aprobando" la Carta, es decir,
usando la defensa sobre el jugador
Parametros:
Sansano jugador
Retorno: void
************************************************/
    private void Aprobar (Sansano jugador) {
        puntosHabilidad = defensa;
        jugador.updatePrioridad(puntosHabilidad);
    }

/******** Funcion: Reprobar ********************
Descripcion: Actualiza la prioridad "reprobando" la Carta, es decir,
usando el ataque sobre el "contrincante"
Parametros:
Sansano jugador
Retorno: void
************************************************/
    private void Reprobar (Sansano jugador) {
        puntosHabilidad = -ataque;
        jugador.updatePrioridad(puntosHabilidad);
    }

/******** Funcion: activar ********************
Descripcion: Activa la carta tipo Cruso en cierta modalidad, por defecto
en modo defensa
Parametros:
Sansano jugador
Retorno: void
************************************************/
    public void activar(Sansano jugador){
        if(Globales.getModoUso().equals("ataque") ){
            Reprobar(jugador);
        }
        else{
            Aprobar(jugador);
        }
    }

/******** Funcion: activar ********************
Descripcion: Activa la carta tipo Curso en cierta modalidad, actualizando
también la ventana de juego
Parametros:
Sansano jugador
PlayView view
Retorno: void
************************************************/
    public void activar(Sansano jugador, PlayView view){
        if(Globales.getModoUso().equals("ataque") ){
            view.setUltimaAccion(jugador.getName()+" es atacado, pierde "+String.valueOf(ataque)+ " puntos de prioridad");
            Reprobar(jugador);
        }
        else{
            view.setUltimaAccion(jugador.getName()+" se defiende, obtiene "+String.valueOf(defensa)+ " puntos de prioridad");
            Aprobar(jugador);
        }
    }
}
