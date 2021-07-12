package com.meli.linktracker.repositories;

import com.meli.linktracker.DTOs.response.LinkResponseDTO;

public interface ILinkRepository {
    
    LinkResponseDTO createAndStore(String link, String linkID);

    String getURL(String linkId);

    Long getMetrics(String linkId);
}
