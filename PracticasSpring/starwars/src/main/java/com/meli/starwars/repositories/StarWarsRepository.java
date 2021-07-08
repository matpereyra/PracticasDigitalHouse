package com.meli.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starwars.dtos.request.CharacterRequestDTO;
import com.meli.starwars.dtos.response.CharacterResponseDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepository implements IStarWarsRepository{


    @Override
    public List<CharacterResponseDTO> searchByName(String characterName) {
        /*
        Creo lista de personajes, con un método privado que cargue la db (el archivo JSON).
         */
        List<CharacterResponseDTO> characterResponseDTOs = loadDB();
        List<CharacterResponseDTO> characters = null;

        if(Objects.nonNull(characterResponseDTOs)){
            characters = characterResponseDTOs
                    .stream()
                    .filter( c -> c.getName().contains(characterName))
                    .collect(Collectors.toList());
        }
        /*
        Devuelve null si no hay nada
         */
        return characters;

    }

    private List<CharacterResponseDTO> loadDB() {
        File file = null;
        try{
            /* Con el "classpath:" busca en la carpeta resources */
            file = ResourceUtils.getFile("classpath:static/starwars.json");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return mapObject(file);
    }

    /*
    Mapea el archivo JSON a una lista de personajes con el formato esperado.
     */
    private List<CharacterResponseDTO> mapObject(File file) {
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<CharacterResponseDTO>> typeReference = new TypeReference<>(){};
        List<CharacterResponseDTO> CharacterResponseDTOs = null;
        try {
            /* El ObjectMapper.readValue recibe el file leido y una instancia de TypeReference
             y crea un objeto del tipo pasado a TypeReference en base a lo leido en el JSON */
            CharacterResponseDTOs = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            e.printStackTrace();
        }
        return CharacterResponseDTOs;
    }
}
