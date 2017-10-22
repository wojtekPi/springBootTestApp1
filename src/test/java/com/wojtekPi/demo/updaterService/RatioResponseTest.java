package com.wojtekPi.demo.updaterService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


public class RatioResponseTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldMapJsonToObject() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        RatioResponse ratioResponse = restTemplate.getForObject("http://api.fixer.io/latest?base=USD",RatioResponse.class);
        assertThat(ratioResponse.getBase()).isEqualToIgnoringCase("USD");
    }
}