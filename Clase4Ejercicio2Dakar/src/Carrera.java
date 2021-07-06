import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Integer distancia;
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> participantes = new ArrayList<>();

    public Carrera(Integer distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public Carrera(Integer distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, List<Vehiculo> participantes) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.participantes = participantes;
    }

    private boolean hayCupo() {
        return participantes.size() < cantidadDeVehiculosPermitidos;
    }

    public void darDeAltaAuto(Float velocidad, Float aceleracion, Float anguloDeGiro, String patente) {
        if (hayCupo()) {
            participantes.add( new Auto(velocidad, aceleracion, anguloDeGiro, patente) );
        }
    }

    public void darDeAltaMoto(Float velocidad, Float aceleracion, Float anguloDeGiro, String patente) {
        if (hayCupo()) {
            participantes.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public Boolean eliminarVehiculo(Vehiculo vehiculo) {
        return participantes.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        eliminarVehiculo(participantes.stream()
                .filter(vehiculo -> unaPatente.equals(vehiculo.getPatente()))
                .findAny()
                .orElse(null));
    }

    public void mostrarParticipantes() {
        for (Vehiculo v: participantes) {
            System.out.println(v.toString());
        }
    }

}
