package com.meli.springapi.DTOs.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Data // creo que crea los getters, setters y constructores
@Validated
public class HouseRequestDTO {

    @NotBlank(message = "La casa debe tener un nombre")
    @NotNull
    public String nombre;

    @NotNull
    public DireccionDTO direccion;

    @NotEmpty(message = "Una casa debe tener al menos una habitación")
    public List<HabitacionDTO> habitaciones;


    public Integer metrosCuadrados() {
        Integer metrosCuadrados = 0;
        for (HabitacionDTO habitacion : this.habitaciones) {
            metrosCuadrados += habitacion.metrosCuadrados();
        }
        return metrosCuadrados;
    }

    public HouseInformation info() {
        return new HouseInformation(
                this.metrosCuadrados(),
                this.precioEnDolares(),
                this.habitacionMasGrande(),
                this.metrosCuadradosPorHabitacion());
    }

    private HashMap<String, Integer> metrosCuadradosPorHabitacion() {
        HashMap<String,Integer> map = new HashMap<>();
        for (HabitacionDTO habitacion: habitaciones) {
            map.put(habitacion.nombre, habitacion.metrosCuadrados());
        }
        return map;
    }

    private HabitacionDTO habitacionMasGrande() {
        Optional<HabitacionDTO> h = habitaciones.stream()
                .max(Comparator.comparing(HabitacionDTO::metrosCuadrados));
        return h.get();
    }

    private Integer precioEnDolares() {
        return 800*this.metrosCuadrados();
    }

}
