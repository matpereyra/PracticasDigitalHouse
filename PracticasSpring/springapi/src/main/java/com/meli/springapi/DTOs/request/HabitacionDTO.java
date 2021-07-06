package com.meli.springapi.DTOs.request;

import lombok.Data;

@Data
public class HabitacionDTO {

    public String nombre;
    public Integer ancho;
    public Integer largo;

    public Integer metrosCuadrados() {
        return ancho*largo;
    }
}
