package com.meli.linktracker.services;

import com.meli.linktracker.DTOs.response.LinkResponseDTO;
import com.meli.linktracker.repositories.ILinkRepository;
import com.meli.linktracker.utils.IURLValidator;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class URLCreator implements IURLCreator {

    ILinkRepository linkRepository;
    IURLValidator urlValidator;

    public URLCreator(ILinkRepository linkRepository, IURLValidator urlValidator) {
        this.linkRepository = linkRepository;
        this.urlValidator = urlValidator;
    }

    @Override
    public LinkResponseDTO createAndStore(String link) {

        urlValidator.validate(link);
        String linkID = encoder(link);
        return linkRepository.createAndStore(link, linkID);
    }

    private String encoder(String link) {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0,5);
    }
}
