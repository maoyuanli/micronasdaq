package com.maotion.micronasdaq.controllers;

import com.maotion.micronasdaq.services.NasdaqDataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NasdaqController {
    private Logger logger = LogManager.getLogger(NasdaqController.class);
    Environment environment;
    private NasdaqDataService nasdaqDataService;

    @Autowired
    public NasdaqController(NasdaqDataService nasdaqDataService,Environment environment) {
        this.nasdaqDataService = nasdaqDataService;
        this.environment =environment;
    }

    @GetMapping("/nasdaq")
    public String nasdaqXQC() {
        logger.debug(String.format("--------the bus.refresh.test value is : %s --------",environment.getProperty("bus.refresh.test")));
        return nasdaqDataService.getQuote();
    }
}
