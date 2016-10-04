import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Globales {
    /*
    // Crear cartas tipo Curso
    static final Curso mate = new Curso("Matemáticas", "Ataca 550/Cura 200 puntos de prioridad.", 550, 200);
    static final Curso fis = new Curso ("Física", "Ataca 450/Cura 150 puntos de prioridad.", 450, 150);
    static final Curso lp = new Curso ("LP", "Ataca 510/Cura 180 puntos de prioridad.", 510, 180);
    static final Curso progra = new Curso("Programación", "Ataca 110/Cura 300 puntos de prioridad.", 110, 300);
    static final Curso ed = new Curso ("ED", "Ataca 470/Cura 160 puntos de prioridad.", 470, 160);
    static final Curso edd = new Curso("EDD", "Ataca 430/Cura 120 puntos de prioridad.", 430, 120);

    // Crear cartas tipo Profesor
    static final Profesor bah = new Profesor("Bahamondes", "Reduce 420 puntos de prioridad.", 420);
    static final Profesor ma = new Profesor("MaxAraya", "Reduce 350 puntos de prioridad.", 350);
    static final Profesor cif = new Profesor("Cifuentes", "Reduce 390 puntos de prioridad.", 390);
    static final Profesor mr = new Profesor("MaxRivera", "Reduce 280 puntos de prioridad.", 280);

    // Crear cartas tipo Carrete
    static final Carrete cerr = new Carrete("Cerrito", "Recupera 55 puntos de prioridad.", 55);
    static final Carrete inter = new Carrete("InterMechón", "Recupera 80 puntos de prioridad.", 80);
    static final Carrete fonda = new Carrete("Sansafonda", "Recupera 100 puntos de prioridad.", 100);
    static final Carrete semana = new Carrete("SemanaSansana", "Recupera 150 puntos de prioridad.", 150);
    static final Carrete libre = new Carrete("BloqueLibre", "Recupera 30 puntos de prioridad.", 30);
    static final Carrete ombligo = new Carrete("FiestaOmbligo", "Recupera 125 puntos de prioridad.", 125);*/

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
        while (posiciones.lastIndexOf(random) == .1){
            random = (random + 7) % 30;
        }
        posiciones.add(random);
        return random;

    }

}
