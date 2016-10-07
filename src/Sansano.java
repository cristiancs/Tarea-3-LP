import java.util.ArrayList;

public class Sansano {

    private String name;
    private int prioridad = 3000;
    private ArrayList mazo = new ArrayList<Carta>(30);

    public Sansano() {
        name = "Oponente";
    }

    public Sansano(String nombre) {
        this.name = nombre;
    }

    public String getName() {
        return name;
    }
    public void setName(String nombre) { this.name = nombre; }

    public int getMazoSize() {
        return this.mazo.size();
    }

    public int getPrioridad() {
        return this.prioridad;
    }

    public void updatePrioridad(int valorCambio) {
        this.prioridad += valorCambio;
        if (prioridad > 3000) {
            this.prioridad = 3000;
        }
        else if (prioridad < 0){
            this.prioridad = 0;
        }

    }

    public void addCard(Carta card){
        this.mazo.add(card);
    }

    public void addCard(Carta card, int pos){
        this.mazo.add(pos, card);
    }

    public Object getCard() {
        Object card = this.mazo.get(0);
        this.mazo.remove(0);
        return card;
    }
}
