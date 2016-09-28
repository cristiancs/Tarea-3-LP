import java.util.Objects;

public abstract class Carta {

    String nombre;
    String descripcion;
    int puntosHabilidad;

    private Carta (String name, String descipt, int puntos){
        nombre = name;
        descripcion = descipt;
        puntosHabilidad = puntos;
    }

    protected void activar(Sansano jugador) {
        jugador.updatePrioridad(puntosHabilidad);
    }

    protected void activar (Sansano jugador, int puntos, String modo) {
        if (Objects.equals(modo, "ataque")){
            puntos = -puntos;
        }
        jugador.updatePrioridad(puntosHabilidad);
    }




}
