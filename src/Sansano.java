public class Sansano {

    protected final String name;
    protected int prioridad;

    private Sansano(String nombre) {
        name = nombre;
        prioridad = 3000;
    }

    public String getName() {
        return name;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int valorCambio) {
        prioridad += valorCambio;
        if (prioridad > 3000) {
            prioridad = 3000;
        }
        else if (prioridad < 0){
            prioridad = 0;
        }
    }
}
