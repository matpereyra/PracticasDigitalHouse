public abstract class Socorrista {

    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo " + vehiculo.getClass().getSimpleName() + " " + vehiculo.getPatente());
    }
}
