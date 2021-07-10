package com.meli.linktracker.repositories;

import com.meli.linktracker.DTOs.response.LinkResponseDTO;

import java.io.IOException;

public interface ILinkRepository {
    
    LinkResponseDTO createAndStore(String link, String linkID);

}
