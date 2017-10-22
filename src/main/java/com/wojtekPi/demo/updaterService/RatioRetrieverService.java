package com.wojtekPi.demo.updaterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RatioRetrieverService {


    private String url;

    @Autowired
    public RatioRetrieverService(@Value("${ratio.retriever.url}") String url) {
        this.url = url;
    }

    public RatioResponse getRatios(String baseCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        String queryUrl = url + baseCurrency;
        RatioResponse ratioResponse = restTemplate.getForObject(queryUrl, RatioResponse.class);
        return ratioResponse;
    }
}
