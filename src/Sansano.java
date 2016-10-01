import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Sansano {

    private final String name;
    private static int prioridad = 3000;
    private List mazo = new ArrayList();

    public Sansano() {
        name = "Oponente";
    }

    public Sansano(String nombre) {
        name = nombre;
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

    public void addCard(Carta card){
        mazo.add(card);
    }

    public Object getCard() {
        int rand = ThreadLocalRandom.current().nextInt(0, mazo.size() + 1);
        Object card = mazo.get(rand);
        mazo.remove(rand);
        return card;
    }
}
