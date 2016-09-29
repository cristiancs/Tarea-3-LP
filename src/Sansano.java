public class Sansano {

    private final String name;
    private int prioridad;

    public Sansano() {
        name = "Oponente";
        prioridad = 3000;
    }

    public Sansano(String nombre) {
        name = nombre;
        prioridad = 3000;
    }

    public String getName() {
        return name;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void updatePrioridad(int valorCambio) {
        prioridad += valorCambio;
        if (prioridad > 3000) {
            prioridad = 3000;
        }
        else if (prioridad < 0){
            prioridad = 0;
        }
    }
}
