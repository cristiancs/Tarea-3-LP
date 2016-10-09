import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

class Globales {
    private static String modoUso;

    protected static void setModoUso(String modoUso) {
        Globales.modoUso = modoUso;
    }
    protected static String getModoUso() {
        return modoUso;
    }

    protected enum Cards {
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
            return descripcion;
        }

        public int getPuntos() {
            return puntos;
        }

        public int getDef() {
            return def;
        }
    }

    protected static void asignarRandom (Sansano jugador){
        int i, rand;
        Carta carta;
        for (Cards cartas : Cards.values()) {
            switch (cartas) {
                case MATE:
                    rand = ThreadLocalRandom.current().nextInt(0, jugador.getMazoSize()+1);
                    carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                    jugador.addCard(carta, rand);
                    break;
                case FIS:
                    for (i = 0; i < 4; i++) {
                        rand = ThreadLocalRandom.current().nextInt(0, jugador.getMazoSize()+1);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case LP:
                    for (i = 0; i < 2; i++) {
                        rand = ThreadLocalRandom.current().nextInt(0, jugador.getMazoSize()+1);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case PROGRA:
                    for (i = 0; i < 6; i++) {
                        rand = ThreadLocalRandom.current().nextInt(0, jugador.getMazoSize()+1);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case ED:
                    for (i = 0; i < 3; i++) {
                        rand = ThreadLocalRandom.current().nextInt(0, jugador.getMazoSize()+1);
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case EDD:
                    for (i = 0; i < 4; i++) {
                        rand = ThreadLocalRandom.current().nextInt(0, jugador.getMazoSize());
                        carta = new Curso(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos(), cartas.getDef());
                        jugador.addCard(carta, rand);
                    }
                    break;
                case BAH:
                case MA:
                case CIF:
                case MR:
                    rand = ThreadLocalRandom.current().nextInt(0, jugador.getMazoSize()+1);
                    carta = new Profesor(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos());
                    jugador.addCard(carta, rand);
                    break;
                case CERR:
                case INTER:
                case FONDA:
                case WEEK:
                case FREE:
                case OMBLIGO:
                    rand = ThreadLocalRandom.current().nextInt(0, jugador.getMazoSize()+1);
                    carta = new Carrete(cartas.getNombre(), cartas.getDescripcion(), cartas.getPuntos());
                    jugador.addCard(carta, rand);
            }
        }
    }

    protected static Object DesarrolloJugada(Duelo juego, PlayView view, Sansano jugador, Sansano jugador2){
        juego.advanceTurno();
        if(juego.getTurno() <= 60 && juego.getGanador().equals("")) {

            view.setNumeroTurno(String.valueOf(juego.getTurno()));
            JButton atacarButton = view.getAtacarButton();
            JButton defendermeButton = view.getDefendermeButton();

            System.out.println(jugador.getPrioridad());
            System.out.println(jugador2.getPrioridad());
            view.setprioridadUsuario(String.valueOf(jugador.getPrioridad()));
            view.setprioridadEnemigo(String.valueOf(jugador2.getPrioridad()));
            Object carta = jugador.getCard();
            view.setCartaActual(((Carta) carta).getNombre());
            if (carta instanceof Curso) {
                defendermeButton.setText("Defenderme");
                atacarButton.setEnabled(true);
                defendermeButton.setEnabled(true);
                view.setValorAtaque(String.valueOf(((Curso) carta).getAtaque()));
                view.setValorDefensa(String.valueOf(((Curso) carta).getDefensa()));
            } else if (carta instanceof Profesor) {
                atacarButton.setEnabled(false);
                defendermeButton.setEnabled(true);
                defendermeButton.setText("Utilizar Carta");

                view.setValorAtaque(String.valueOf(((Profesor) carta).getPuntosHabilidad()));
                view.setValorDefensa(" ");
            } else if (carta instanceof Carrete) {
                atacarButton.setEnabled(false);
                defendermeButton.setEnabled(true);
                defendermeButton.setText("Utilizar Carta");
                view.setValorDefensa(String.valueOf(((Carrete) carta).getPuntosHabilidad()));
                view.setValorAtaque(" ");

            }

            if (jugador.getPrioridad() == 0) {
                juego.setGanador(jugador2.getName());
                view.setVisible(false);
            }
            if (jugador2.getPrioridad() == 0) {
                juego.setGanador(jugador.getName());
                view.setVisible(false);
            }
            return carta;
        }
        else {
            if (jugador.getPrioridad() >  jugador2.getPrioridad()) {
                juego.setGanador(jugador.getName());
                view.setVisible(false);
            }
            else if(jugador.getPrioridad() < jugador2.getPrioridad()) {
                juego.setGanador(jugador2.getName());
                view.setVisible(false);
            }
            else {
                juego.setGanador("EMPATE");
                view.setVisible(false);
            }
            return null;
        }
    }
}
