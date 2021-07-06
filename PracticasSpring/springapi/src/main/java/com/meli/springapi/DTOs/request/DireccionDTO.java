package com.meli.springapi.DTOs.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DireccionDTO {

    public String nombreCalle;
    public Integer altura;
}
