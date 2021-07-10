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
@RequestMapping("/")
public class APIController {

    URLCreator urlCreator;
    @Autowired
    HttpRequestor httpRequestor;

    public APIController(URLCreator urlCreator) {
        this.urlCreator = urlCreator;
        this.httpRequestor = httpRequestor;
    }

    @PostMapping("/new/{link}") //todo: deberia recibir un objeto con varios parametros, no un stirng
    public ResponseEntity<LinkResponseDTO> createLinkID(@PathVariable String link) {
        return new ResponseEntity<>(urlCreator.createAndStore("https://www.google.com/"), HttpStatus.OK);
    }


    @PostMapping("/new2") //Atributos de la clase LinkRequestDTO
    public ResponseEntity<LinkResponseDTO> createLinkID_2(@Valid @RequestBody LinkRequestDTO linkRequestDTO) {
        //return new ResponseEntity<>(linkRequestDTO, HttpStatus.OK);
        return new ResponseEntity<>(urlCreator.createAndStore(linkRequestDTO.toString()), HttpStatus.OK);
    }


    @GetMapping("/google")
    public ResponseEntity<String> HttpRequestGoogle() {
        return new ResponseEntity<>("Todo bien :)", httpRequestor.requestStatus("https://www.google.com/"));
    }
}
