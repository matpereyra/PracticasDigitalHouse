package com.meli.linktracker.controllers;

import com.meli.linktracker.services.URLIDFinder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/metrics")
@Validated
public class MetricsController {


    URLIDFinder urlidFinder;

    public MetricsController(URLIDFinder urlidFinder) {
        this.urlidFinder = urlidFinder;
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<Long> findAndGetMetrics(@PathVariable(name="linkId") @NotNull @Size(min=5,max=5) String linkId) {
        return urlidFinder.findAndGetMetrics(linkId);
    }
}
