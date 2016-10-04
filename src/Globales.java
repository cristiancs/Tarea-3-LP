import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Globales {

    public enum Cards {
        // Crear cartas de Curso
        MATE("Matemáticas", "Ataca 550/Cura 200 puntos de prioridad.", 550, 200),
        FIS("Física", "Ataca 450/Cura 150 puntos de prioridad.", 450, 150),
        LP("LP", "Ataca 510/Cura 180 puntos de prioridad.", 510, 180),
        PROGRA("Programación", "Ataca 110/Cura 300 puntos de prioridad.", 110, 300),
        ED("ED", "Ataca 470/Cura 160 puntos de prioridad.", 470, 160),
        EDD("EDD", "Ataca 430/Cura 120 puntos de prioridad.", 430, 120),

        // Crear cartas de Profesor
        BAH("Bahamondes", "Reduce 420 puntos de prioridad.", 420),
        MA("MaxAraya", "Reduce 350 puntos de prioridad.", 350),
        CIF("Cifuentes", "Reduce 390 puntos de prioridad.", 390),
        MR("MaxRivera", "Reduce 280 puntos de prioridad.", 280),

        // Crear cartas de Carrete
        CERR("Cerrito", "Recupera 55 puntos de prioridad.", 55),
        INTER("InterMechón", "Recupera 80 puntos de prioridad.", 80),
        FONDA("Sansafonda", "Recupera 100 puntos de prioridad.", 100),
        WEEK("SemanaSansana", "Recupera 150 puntos de prioridad.", 150),
        FREE("BloqueLibre", "Recupera 30 puntos de prioridad.", 30),
        OMBLIGO("FiestaOmbligo", "Recupera 125 puntos de prioridad.", 125);

        private String nombre;
        private String descripcion;
        private int puntos;
        private int def;

        // Constructor
        Cards(String cardName, String cardDes, int ataque, int defensa) {
            this.nombre = cardName;
            this.descripcion = cardDes;
            this.puntos = ataque;
            this.def = defensa;
        }

        Cards(String cardName, String cardDes, int puntosHabilidad) {
            this.nombre = cardName;
            this.descripcion = cardDes;
            this.puntos = puntosHabilidad;
        }

        public String getNombre() {
            return this.nombre;
        }

        public String getDescripcion() {
            return this.descripcion;
        }

        public int getPuntos() {
            return puntos;
        }

        public int getDef() {
            return def;
        }
    }

    public int randomMazo (List<Integer> posiciones){
        int random = ThreadLocalRandom.current().nextInt(0, 30);
        int test = posiciones.lastIndexOf(random);
        while (posiciones.lastIndexOf(random) != -1){
            random = (random + 7) % 30;
        }
        posiciones.add(random);
        return random;

    }

    public void asignarRandom (Sansano jugador){
        int rand, i;
        Carta carta;
        Globales global = new Globales();
        List<Integer> posiciones = new ArrayList<>();
        for (Globales.Cards cartas : Globales.Cards.values()) {
            switch (cartas) {
                case MATE:
                    rand = global.randomMazo(posiciones);
                    carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                    jugador.addCard(carta, rand);
                    break;
                case FIS:
                    for (i = 0; i < 4; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case LP:
                    for (i = 0; i < 2; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case PROGRA:
                    for (i = 0; i < 6; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case ED:
                    for (i = 0; i < 3; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case EDD:
                    for (i = 0; i < 4; i++) {
                        rand = global.randomMazo(posiciones);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case BAH:
                case MA:
                case CIF:
                case MR:
                    rand = global.randomMazo(posiciones);
                    carta = new Profesor(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos());
                    jugador.addCard(carta, rand);
                    break;
                case CERR:
                case INTER:
                case FONDA:
                case WEEK:
                case FREE:
                case OMBLIGO:
                    rand = global.randomMazo(posiciones);
                    carta = new Carrete(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos());
                    jugador.addCard(carta, rand);

            }
        }
    }
}
