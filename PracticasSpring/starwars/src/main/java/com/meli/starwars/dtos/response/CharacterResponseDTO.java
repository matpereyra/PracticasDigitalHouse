package com.meli.starwars.dtos.response;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
public class CharacterResponseDTO {

    /*
    TODO: cómo trabajar con tipos de dato erróneos en el JSON?
     */
    public String name;
    public Object height;
    public Object mass;
    public String hair_color;
    public String skin_color;
    public String eye_color;
    public String birth_year;
    public String gender;
    public String homeworld;
    public String species;
}
