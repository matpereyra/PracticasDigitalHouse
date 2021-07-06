package com.meli.demoromannumbersapp.controllers;


import com.meli.demoromannumbersapp.models.RomanNumber;
import com.meli.demoromannumbersapp.utils.NumberConverter;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/numbers")
public class NumberCoverterController {

    // /numbers/toDecimal

    @GetMapping("/toDecimal")
    public RomanNumber romanToDecimal1(@RequestParam(value = "roman", defaultValue = "X") String roman) {

        return new RomanNumber(NumberConverter.romanToDecimal(roman));
    }

    @GetMapping("/toDecimal/{decimal}")
    public RomanNumber romanToDecimal2(@PathVariable(value = "decimal") String roman) {

        return new RomanNumber(NumberConverter.romanToDecimal(roman));
    }


}