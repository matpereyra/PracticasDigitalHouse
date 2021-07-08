package com.meli.starwars.controllers;

import com.meli.starwars.dtos.request.CharacterRequestDTO;
import com.meli.starwars.dtos.response.CharacterResponseDTO;
import com.meli.starwars.services.ISearcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    ISearcher searcher;

    public StarWarsController(ISearcher searcher) {
        this.searcher = searcher;
    }

    @GetMapping("/search")
    public ResponseEntity<List<CharacterResponseDTO>> searchForCharacter(@Valid @RequestBody CharacterRequestDTO characterRequest) {
        //si por path solo recibo 1 paramatro, no usar un DTO
        return new ResponseEntity<>(searcher.byName(characterRequest), HttpStatus.OK);
    }

    // {name }   (@PathVariable @NotBlank @Size(min=10) String name

}
















