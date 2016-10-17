public class Juego {

/******** Funcion: main ********************
Descripcion: main del juego SansaStone
Parametros:
String[] args
Retorno: void
************************************************/
    public static void main(String[] args) {
        Sansano s1 = new Sansano();
        Sansano s2 = new Sansano();
        new ModoJuegoView(s1, s2);
    }
}
