package com.meli.demoromannumbersapp.controllers;


import com.meli.demoromannumbersapp.models.NumberConverter;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/numbers")
public class NumberCoverterController {

    // /numbers/toDecimal
    /*
    @GetMapping("/toDecimal")
    public Integer romanToDecimal(@RequestParam(value = "decimal", defaultValue = "999") String decimal) {
        return 5;//NumberConverter.romanToDecimal(decimal);
    }
     */
    @GetMapping("/toDecimal/{decimal}")
    public Integer romanToDecimal(@PathVariable(value = "decimal") String decimal) {
        return NumberConverter.romanToDecimal(decimal);
    }


}