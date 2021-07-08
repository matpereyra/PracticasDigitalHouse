package com.meli.starwars.services;

import com.meli.starwars.dtos.request.CharacterRequestDTO;
import com.meli.starwars.dtos.response.CharacterResponseDTO;

import java.util.List;

public interface ISearcher {

    List<CharacterResponseDTO> byName(CharacterRequestDTO characterName);
}
