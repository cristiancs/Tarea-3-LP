import java.util.List;

public class Juego {

    public static void main(String[] args) {

        // Crear cartas tipo Curso
        Curso mate = new Curso("Matemáticas", "Ataca 550/Cura 200 puntos de prioridad.", 550, 200);
        Curso fis = new Curso ("Física", "Ataca 450/Cura 150 puntos de prioridad.", 450, 150);
        Curso lp = new Curso ("LP", "Ataca 510/Cura 180 puntos de prioridad.", 510, 180);
        Curso progra = new Curso("Programación", "Ataca 110/Cura 300 puntos de prioridad.", 110, 300);
        Curso ed = new Curso ("ED", "Ataca 470/Cura 160 puntos de prioridad.", 470, 160);
        Curso edd = new Curso("EDD", "Ataca 430/Cura 120 puntos de prioridad.", 430, 120);

        // Crear cartas tipo Profesor
        Profesor bah = new Profesor("Bahamondes", "Reduce 420 puntos de prioridad.", 420);
        Profesor ma = new Profesor("MaxAraya", "Reduce 350 puntos de prioridad.", 350);
        Profesor cif = new Profesor("Cifuentes", "Reduce 390 puntos de prioridad.", 390);
        Profesor mr = new Profesor("MaxRivera", "Reduce 280 puntos de prioridad.", 280);

        // Crear cartas tipo Carrete
        Carrete cerr = new Carrete("Cerrito", "Recupera 55 puntos de prioridad.", 55);
        Carrete inter = new Carrete("InterMechón", "Recupera 80 puntos de prioridad.", 80);
        Carrete fonda = new Carrete("Sansafonda", "Recupera 100 puntos de prioridad.", 100);
        Carrete semana = new Carrete("SemanaSansana", "Recupera 150 puntos de prioridad.", 150);
        Carrete libre = new Carrete("BloqueLibre", "Recupera 30 puntos de prioridad.", 30);
        Carrete ombligo = new Carrete("FiestaOmbligo", "Recupera 125 puntos de prioridad.", 125);


        // TESTEO
        Sansano player = new Sansano("asd");
        Sansano pc = new Sansano();
        player.addCard(cerr);
        Object actual = player.getCard(0);


        ModoJuegoView portada =  new ModoJuegoView();

    }
}
