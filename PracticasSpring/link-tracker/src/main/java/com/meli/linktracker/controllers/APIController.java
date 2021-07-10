package com.meli.linktracker.controllers;

import com.meli.linktracker.DTOs.response.LinkResponseDTO;
import com.meli.linktracker.services.HttpRequestor;
import com.meli.linktracker.services.URLCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/new/{link}")
    public ResponseEntity<LinkResponseDTO> createLinkID(@PathVariable String link) throws Exception {
        // Este comentario es para probar commitear desde el intelliJ
        return new ResponseEntity<>(urlCreator.createAndStore(link), HttpStatus.OK);
    }

    @GetMapping("/google")
    public ResponseEntity<String> HttpRequestGoogle() {
        return new ResponseEntity<>(httpRequestor.request("https://www.google.com/"), HttpStatus.OK);
    }
}
