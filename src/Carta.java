public abstract class Carta {

    protected String nombre;
    protected String descripcion;
    protected int puntosHabilidad;
    protected String tipo;

/******** Funcion: activar ********************
Descripcion: Activa la Carta según el tipo, 
debe ser redefinida
Parametros:
Sansano jugador
Retorno: void
************************************************/
    protected abstract void activar(Sansano jugador);

/******** Funcion: activar ********************
Descripcion: Activa la Carta según el tipo y además
hace los cambios sobre la ventana, debe ser redefinida
Parametros:
Sansano jugador
PlayView view
Retorno: void
************************************************/
    protected abstract void activar(Sansano jugador, PlayView view);

/******** Funcion: getPuntosHabilidad ********************
Descripcion: Obtiene el valor actual de puntosHabilidad
Parametros: 
None
Retorno: int de los puntos de habilidad
************************************************/
    public int getPuntosHabilidad (){ return puntosHabilidad; }

/******** Funcion: getNombre ********************
Descripcion: Obtiene el nombre de la Carta
Parametros:
None
Retorno: String del nombre de la Carta
************************************************/
    public String getNombre() {
        return nombre;
    }

/******** Funcion: getDescripcion ********************
Descripcion: Obtiene la descripcion de la Carta
Parametros:
None
Retorno: String de la descripcion de la Carta
************************************************/
    public String getDescripcion() {
        return descripcion;
    }
}
