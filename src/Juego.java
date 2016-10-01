import java.util.List;

public class Juego {

    public static void main(String[] args) {

        // TESTEO
        Sansano player = new Sansano("asd");
        Sansano pc = new Sansano();
        /*player.addCard(cerr);
        player.addCard(ma);
        player.addCard(mate);
        player.addCard(mate);
        player.addCard(mate);
        Object pasajera = player.getCard();
        */
        UnJugador juego = new UnJugador();
        juego.asignarCartas(player, pc);

        ModoJuegoView portada =  new ModoJuegoView();

    }
}
