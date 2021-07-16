package com.meli.linktracker.controllers;

import com.meli.linktracker.services.URLIDFinder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/test1/{linkId}")
    public RedirectView findAndRedirect_TEST1(@PathVariable(name="linkId") @NotNull @Size(min=5,max=5) String linkId) {
        return new RedirectView("https://www.google.com/");
    }

    @GetMapping("/test2/{linkId}")
    public ResponseEntity<Object> findAndRedirect_TEST2(@PathVariable(name="linkId") @NotNull @Size(min=5,max=5) String linkId) {
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("https://fullstackdeveloper.guru")).build();
    }

}
