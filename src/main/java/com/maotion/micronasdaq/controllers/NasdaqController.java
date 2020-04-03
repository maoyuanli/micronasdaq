package com.maotion.micronasdaq.controllers;

import com.maotion.micronasdaq.services.NasdaqDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NasdaqController {

    private NasdaqDataService nasdaqDataService;

    @Autowired
    public NasdaqController(NasdaqDataService nasdaqDataService) {
        this.nasdaqDataService = nasdaqDataService;
    }

    @GetMapping("/nasdaq")
    public String nasdaqXQC() {
        return nasdaqDataService.getQuote();
    }
}
