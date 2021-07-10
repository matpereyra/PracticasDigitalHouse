package com.meli.linktracker.controllers;

import com.meli.linktracker.DTOs.response.LinkResponseDTO;
import com.meli.linktracker.services.URLCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class APIController {

    URLCreator urlCreator;

    public APIController(URLCreator urlCreator) {
        this.urlCreator = urlCreator;
    }

    @PostMapping("/new/{link}")
    public ResponseEntity<LinkResponseDTO> createLinkID(@PathVariable String link) throws Exception {
        return new ResponseEntity<>(urlCreator.createAndStore(link), HttpStatus.OK);
    }
}
