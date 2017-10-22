package com.wojtekPi.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CurrenciesRestController {


    private final CurrencyRatioRepository currencyRatioRepository;

    public CurrenciesRestController(CurrencyRatioRepository currencyRatioRepository) {
        this.currencyRatioRepository = currencyRatioRepository;
    }

    @RequestMapping("/currenciesRatio")
    Collection<CurrencyRatio> currencyRatios() {
        return currencyRatioRepository.findAll();
    }

}
