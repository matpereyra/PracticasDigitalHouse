public class Auto extends Vehiculo{

    private static final Float PESO = 300.0f;
    private static final Integer RUEDAS = 2;

    public Auto(Float velocidad, Float aceleracion, Float anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
    }

}
