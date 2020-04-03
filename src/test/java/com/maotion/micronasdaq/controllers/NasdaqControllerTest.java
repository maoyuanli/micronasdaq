package com.maotion.micronasdaq.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class NasdaqControllerTest {
    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    void nasdaqXQC() throws Exception {
        String QUOTE_URI = "/nasdaq";
        List<String> EXPECTED_RESPONSE_KEYWORDS = Arrays.asList("dataset", "id", "column_names", "database_code", "NASDAQOMX", "data", "start_date", "end_date");
        RequestTestTemplate.testMvcRequest(webApplicationContext, QUOTE_URI, null, 200, EXPECTED_RESPONSE_KEYWORDS);
    }
}