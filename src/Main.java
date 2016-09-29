public class Main {
    public static void main(String[] args) {
        Curso ed = new Curso("asd","dsa",500, 200);
        Profesor leonel = new Profesor("Leonel", "rajon", 150);
        Carrete cerrito = new Carrete("Cerrito", "a tomar", 350);
        Sansano player = new Sansano("jp");
        ed.Reprobar(player);
        ed.Aprobar(player);
        ed.Aprobar(player);
        ed.Aprobar(player);
        ed.Reprobar(player);
        leonel.activar(player);
        cerrito.activar(player);
        ed.Reprobar(player);
        ed.Reprobar(player);
        ed.Reprobar(player);
        ed.Reprobar(player);
        ed.Reprobar(player);
        ed.Reprobar(player);
        ed.Reprobar(player);

        System.out.println("Hello World!");
    }
}
