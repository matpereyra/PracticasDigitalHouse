public abstract class Vehiculo {
    Float velocidad;
    Float aceleracion;
    Float anguloDeGiro;
    String patente;
    Float peso;
    Integer ruedas;

    public Vehiculo(Float velocidad, Float aceleracion, Float anguloDeGiro, String patente, Float peso, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }

    public void socorridoPor(Socorrista socorrista) {
    }







}
