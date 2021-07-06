public class Main {

    public static void main(String[] args) {

        Carrera carrera = new Carrera(1000, 500, "Dakar", 4);

        carrera.darDeAltaAuto(130f, 50f, 23f, "ABC 123");
        carrera.darDeAltaMoto(110f, 40f, 14f, "QQQ 987");

        carrera.mostrarParticipantes();
        System.out.println();

        carrera.eliminarVehiculoConPatente("ABC 123");
        carrera.mostrarParticipantes();
    }
}
