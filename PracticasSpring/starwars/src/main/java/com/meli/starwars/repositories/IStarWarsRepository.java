package com.meli.starwars.repositories;

import com.meli.starwars.dtos.request.CharacterRequestDTO;
import com.meli.starwars.dtos.response.CharacterResponseDTO;

import java.util.List;

public interface IStarWarsRepository {

    List<CharacterResponseDTO> searchByName(String characterName);

}
