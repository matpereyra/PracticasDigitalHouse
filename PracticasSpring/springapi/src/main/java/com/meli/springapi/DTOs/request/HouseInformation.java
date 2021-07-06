package com.meli.springapi.DTOs.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class HouseInformation {

    public Integer metrosCuadradosTotales;
    public Integer precioEnDolares;
    public HabitacionDTO habitacionMasGrande;
    public HashMap<String, Integer> metrosCuadradosPorHabitacion;

}
