package com.meli.demoromannumbersapp.controllers;


import com.meli.demoromannumbersapp.utils.NumberConverter;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/numbers")
public class NumberCoverterController {

    // /numbers/toDecimal

    @GetMapping("/toDecimal")
    public Integer romanToDecimal1(@RequestParam(value = "decimal", defaultValue = "100") String decimal) {
        return NumberConverter.romanToDecimal(decimal);
    }

    @GetMapping("/toDecimal/{decimal}")
    public Integer romanToDecimal2(@PathVariable(value = "decimal") String decimal) {
        return NumberConverter.romanToDecimal(decimal);
    }


}