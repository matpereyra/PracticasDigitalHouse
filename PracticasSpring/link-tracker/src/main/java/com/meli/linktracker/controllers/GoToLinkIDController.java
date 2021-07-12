package com.meli.linktracker.controllers;

import com.meli.linktracker.DTOs.request.LinkRequestDTO;
import com.meli.linktracker.DTOs.response.LinkResponseDTO;
import com.meli.linktracker.services.HttpRequestor;
import com.meli.linktracker.services.URLCreator;
import com.meli.linktracker.services.URLIDFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URI;

@RestController
@RequestMapping("/link")
@Validated
public class GoToLinkIDController {


    URLIDFinder urlidFinder;

    public GoToLinkIDController(URLIDFinder urlidFinder) {
        this.urlidFinder = urlidFinder;
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<Void> findAndRedirect(@PathVariable(name="linkId") @NotNull @Size(min=5,max=5) String linkId) {
        return urlidFinder.findAndRedirect(linkId);
    }
    //return new RedirectView("https://www.google.com/");
    //ResponseEntity.status(HttpStatus.FOUND).location(URI.create("https://fullstackdeveloper.guru")).build();
}
