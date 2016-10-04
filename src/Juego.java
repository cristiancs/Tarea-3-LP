public class Juego {

    public static void main(String[] args) {
        Sansano jugador = new Sansano("asd");
        Sansano pc = new Sansano("Oponente");
        UnJugador prueba = new UnJugador();
        prueba.asignarCartas(jugador, pc, 1);
        ModoJuegoView portada =  new ModoJuegoView();

    }
}
