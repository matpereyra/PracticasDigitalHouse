package com.meli.linktracker.services;

import com.meli.linktracker.repositories.ILinkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class URLIDFinder {

    ILinkRepository linkRepository;

    public URLIDFinder(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public ResponseEntity<Void> findAndRedirect(String linkId) {
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(linkRepository.getURL(linkId))).build();
    }

    public ResponseEntity<Long> findAndGetMetrics(String linkId) {
        return new ResponseEntity<Long>(linkRepository.getMetrics(linkId), HttpStatus.OK);
    }
}
