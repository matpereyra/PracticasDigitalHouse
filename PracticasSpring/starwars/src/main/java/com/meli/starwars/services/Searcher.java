package com.meli.starwars.services;

import com.meli.starwars.dtos.request.CharacterRequestDTO;
import com.meli.starwars.dtos.response.CharacterResponseDTO;
import com.meli.starwars.repositories.IStarWarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Searcher implements ISearcher{

    IStarWarsRepository starWarsRepo;

    public Searcher(IStarWarsRepository starWarsRepo) {
        this.starWarsRepo = starWarsRepo;
    }

    @Override
    public List<CharacterResponseDTO> byName(CharacterRequestDTO characterRequest) {
        return starWarsRepo.searchByName(characterRequest.getName());
    }
}
