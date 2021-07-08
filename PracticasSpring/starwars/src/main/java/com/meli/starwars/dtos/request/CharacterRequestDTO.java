package com.meli.starwars.dtos.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Validated
public class CharacterRequestDTO {

    @Size(min = 1, max = 20)
    @NotBlank(message = "No name entered.")
    public String name;


}
