package com.meli.springapi.controllers;

import com.meli.springapi.DTOs.request.HouseInformation;
import com.meli.springapi.DTOs.request.HouseRequestDTO;
import com.meli.springapi.DTOs.response.HouseResponseDTO;
import com.meli.springapi.handlers.HouseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/house")
public class HouseController {

    @PostMapping("/informacion")
    public ResponseEntity<HouseInformation> calculosSobreCasa(@Valid @RequestBody HouseRequestDTO house) {
        // Creo el objeto response, el cual debe tener un status.
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(
                /* Estos parametros del constructor deberían implementar la validacion de la casa
                según la lógica de negocio y devolver un mensaje sobre el estado de las operaciones.
                */
                HouseHandler.validateHouse(),
                HouseHandler.saveHouse()
        );

        // Devuelvo una Responseentity, que recibe la Response del DTO recibido y el status OK.
        // El response entityt parsea a JSON el DTO
        return new ResponseEntity<>(house.info(), HttpStatus.OK);
    }

}
