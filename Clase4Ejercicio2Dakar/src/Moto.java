public class Moto extends Vehiculo{

    private static final Float PESO = 300.0f;
    private static final Integer RUEDAS = 2;

    public Moto(Float velocidad, Float aceleracion, Float anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, Moto.PESO, Moto.RUEDAS);
    }

}
