
public class Curso extends Carta {

    int puntosDefensa;

    public Curso (String name, String descript, int puntos) {
        nombre = name;
        descripcion = descript;
        puntosHabilidad = puntos;
        puntosDefensa = puntos - 3;
    }

    public void aprobar () {
        System.out.print("Hola");
    }

    public void reprobar () {}
}
