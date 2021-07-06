package com.meli.springapi.DTOs.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HouseResponseDTO {

    private String validationState;
    private String savingState;


}
