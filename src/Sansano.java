import java.util.ArrayList;
import java.util.List;

public class Sansano {

    private final String name;
    private static int prioridad = 3000;
    private List mazo = new ArrayList(30);

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

    public void addCard(Carta card, int pos){
        mazo.set(pos, card);
    }

    public Object getCard() {
        Object card = mazo.get(0);
        return card;
    }
}
