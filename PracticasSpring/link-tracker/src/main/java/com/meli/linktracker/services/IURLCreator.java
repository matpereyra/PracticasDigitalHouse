package com.meli.linktracker.services;

import com.meli.linktracker.DTOs.response.LinkResponseDTO;

public interface IURLCreator {

    LinkResponseDTO createAndStore(String link);
}
