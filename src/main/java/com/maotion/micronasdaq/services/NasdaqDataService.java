package com.maotion.micronasdaq.services;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.maotion.micronasdaq.entities.Quote;
import com.maotion.micronasdaq.utils.DateRangeProvider;
import com.maotion.micronasdaq.utils.TokenFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class NasdaqDataService {

    private DateRangeProvider dateRangeProvider;

    @Autowired
    public NasdaqDataService(DateRangeProvider dateRangeProvider) {
        this.dateRangeProvider = dateRangeProvider;
    }

    public String getQuote() {
        return quotesBundler();
    }

    public String quotesBundler() {
        TokenFetcher tokenFetcher = new TokenFetcher("token.json");
        String QUANDL_TOKEN = tokenFetcher.fetchToken("quandl_key");
        String QUANDL_API_URL = "https://www.quandl.com/api/v3/datasets/NASDAQOMX/XQC.json?api_key=%s&start_date=%s&end_date=%s";
        List<String> startEndDate = dateRangeProvider.startAndEndDate(1);
        String startDate = startEndDate.get(0);
        String endDate = startEndDate.get(1);
        RestTemplate restTemplate = new RestTemplate();
        String quandlUrl = String.format(QUANDL_API_URL, QUANDL_TOKEN, startDate, endDate);
        Quote quote = restTemplate.getForObject(quandlUrl, Quote.class);
        Gson gson = new Gson();
        String quoteGson = gson.toJson(quote);
        JsonObject jsonResult = (JsonObject) new JsonParser().parse(quoteGson);
        return jsonResult.toString();
    }

}
