package com.meli.linktracker.controllers;

import com.meli.linktracker.DTOs.request.LinkRequestDTO;
import com.meli.linktracker.DTOs.response.LinkResponseDTO;
import com.meli.linktracker.services.HttpRequestor;
import com.meli.linktracker.services.URLCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/new")
public class NewLinkController {

    URLCreator urlCreator;
    @Autowired
    HttpRequestor httpRequestor;

    public NewLinkController(URLCreator urlCreator) {
        this.urlCreator = urlCreator;
        //this.httpRequestor = httpRequestor;
    }


    @PostMapping("/")
    public ResponseEntity<LinkResponseDTO> createLinkID(@Valid @RequestBody LinkRequestDTO linkRequestDTO) {
        return new ResponseEntity<>(urlCreator.createAndStore(linkRequestDTO.toString(), linkRequestDTO.hashPassword()),
                                    HttpStatus.OK);
    }

    /*
    TODO: endpoint de prueba
     */
    @GetMapping("/google")
    public ResponseEntity<String> HttpRequestGoogle() {
        return new ResponseEntity<>("Todo bien :)", httpRequestor.requestStatus("https://www.google.com/"));
    }



}
