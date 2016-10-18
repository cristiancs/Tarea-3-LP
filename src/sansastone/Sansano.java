package sansastone;

import java.util.ArrayList;
import java.util.List;

public class Sansano {

    private String name;
    private int prioridad = 3000;
    private List<Carta> mazo = new ArrayList<>(30);

/******** Funcion: Sansano ********************
Descripcion: Constructor para un jugador sin nombre, por defecto
se define para el computador (Oponente)
Parametros:
None
************************************************/
    public Sansano() {
        name = "Oponente";
    }

/******** Funcion: Sansano ********************
Descripcion: Constructor para un jugador con su nombre
Parametros:
String nombre
************************************************/
    public Sansano(String nombre) {
        this.name = nombre;
    }

/******** Funcion: getName ********************
Descripcion: Obtiene el nombre del jugador
Parametros:
None
Retorno: String con el nombre del jugador
************************************************/
    public String getName() {
        return name;
    }

/******** Funcion: setName ********************
Descripcion: Establece el nombre del jugador
Parametros:
String nombre
Retorno: void
************************************************/
    public void setName(String nombre) { this.name = nombre; }

/******** Funcion: setMazoSize ********************
Descripcion: Obtiene el tamanio del mazo
Parametros:
None
Retorno: int con el tamanio del mazo
************************************************/
    public int getMazoSize() {
        return this.mazo.size();
    }

/******** Funcion: getPrioridad ********************
Descripcion: Obtiene la prioridad del Sansano
Parametros:
None
Retorno: int con la prioridad actual
************************************************/
    public int getPrioridad() {
        return this.prioridad;
    }

/******** Funcion: updatePrioridad ********************
Descripcion: actualiza la prioridad con los puntos de habilidad
correspondientes, estableciendo el nuevo valor ente 0 y 3000
Parametros:
int valorCambio
Retorno: void
************************************************/
    public void updatePrioridad(int valorCambio) {
        this.prioridad += valorCambio;
        if (prioridad > 3000) {
            this.prioridad = 3000;
        }
        else if (prioridad < 0){
            this.prioridad = 0;
        }

    }

/******** Funcion: addCArd ********************
Descripcion: agrega una Carta al mazo en la posicion final
Parametros:
Carta card
Retorno: void
************************************************/
    public void addCard(Carta card){
        this.mazo.add(card);
    }

/******** Funcion: addCard ********************
Descripcion: agrega una Carta al mazo en la posicion especifica
Parametros:
String ganador
Retorno: void
************************************************/
    public void addCard(Carta card, int pos){
        this.mazo.add(pos, card);
    }

/******** Funcion: getCard ********************
Descripcion: obtiene la carta en la posicion inicial del mazo
Parametros:
None
Retorno: Object que representa la Carta obtenida
************************************************/
    public Object getCard() {
        Object card = this.mazo.get(0);
        this.mazo.remove(0);
        return card;
    }
}