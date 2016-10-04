import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Sansano {

    private final String name;
    private static int prioridad = 3000;
    private ArrayList mazo;

    public Sansano() {
        mazo = new ArrayList<Carta>(30);
        name = "Oponente";
    }

    public Sansano(String nombre) {
        mazo = new ArrayList<Carta>(Collections.nCopies(30, null));
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
