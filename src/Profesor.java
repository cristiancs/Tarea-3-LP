public class Profesor extends Carta {

    protected int danio;

/******** Funcion: Profesor ********************
Descripcion: Constroctor de la Carta tipo Profesor, estableciendo
atributos: nombre, descripcion, daño y tipo
Parametros:
String name
String descript
int damage
************************************************/
    public Profesor (String name, String descript, int damage) {
        nombre = name;
        descripcion = descript;
        danio = puntosHabilidad = damage;
        tipo = "profesor";
    }

/******** Funcion: activar ********************
Descripcion: activa la carta sobre el sansano usando Recorregir
Parametros:
Sansano jugador
Retorno: void
************************************************/
    public void activar(Sansano jugador) {
        Recorregir(jugador);
    }

/******** Funcion: activar ********************
Descripcion: activa la carta sobre el sansano usando recorregir y
actualiza la ventana
Parametros:
Sansano jugador
PlayView view
Retorno: void
************************************************/
    public void activar(Sansano jugador, PlayView view) {
        view.setUltimaAccion(jugador.getName()+" obtiene carta Profesor, pierde "+String.valueOf(danio)+ " puntos de prioridad");
        Recorregir(jugador);
    }

/******** Funcion: Recorregir ********************
Descripcion: actualiza la prioridad del sansano restándole
el daño correspondiente del Profesor
Parametros:
Sansano jugador
Retorno: void
************************************************/
    private void Recorregir (Sansano jugador){
        jugador.updatePrioridad(-danio);
    }
}
