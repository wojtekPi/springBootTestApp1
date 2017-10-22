package com.wojtekPi.demo.updaterService;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RatioRetrieverServiceTest {
    private RatioRetrieverService testedObject;

    @Before
    public void setUp() throws Exception {
        testedObject=new RatioRetrieverService("http://api.fixer.io/latest?base=");
    }

    @Test
    public void getRatios() throws Exception {
        RatioResponse response = testedObject.getRatios("USD");
        assertThat(response.getBase()).isEqualToIgnoringCase("USD");
    }

}