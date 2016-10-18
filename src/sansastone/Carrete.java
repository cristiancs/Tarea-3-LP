package sansastone;

public class Carrete extends Carta {

    protected int curacion;

/******** Funcion: Carrete ********************
Descripcion: Constructor Carta tipo Carrete, incluyendo nombre
description, tipo y curacion
Parametros:
String name
String descript
int heal
************************************************/
    public Carrete (String name, String descript, int heal) {
        nombre = name;
        descripcion = descript;
        tipo = "carrete";
        curacion = puntosHabilidad = heal;
    }

/******** Funcion: activar ********************
Descripcion: Redefine el activar de Carta, esta vez actualizando
prioridad según el tipo Carrete
Parametros:
Sansano jugador
Retorno: void
************************************************/
    public void activar(Sansano jugador) {
        Carretear(jugador);
    }

/******** Funcion: activar ********************
Descripcion: utiliza Carretear sobre jugador y ademas actualiza
la ventana con la información pertinente
Parametros:
Sansano jugador
PlayView view
Retorno: void
************************************************/
    public void activar(Sansano jugador, PlayView view) {
        Carretear(jugador);
        view.setUltimaAccion(jugador.getName()+" obtiene carta Carrete, recupera "+String.valueOf(curacion)+ " puntos de prioridad");
    }
    
/******** Funcion: Carretear ********************
Descripcion: Actualiza la prioridad según la funcionalidad de las cartas
tipo Carrete
Parametros:
Sansano jugador
Retorno: void
************************************************/
    private void Carretear(Sansano jugador) {
        jugador.updatePrioridad(curacion);
    }
}