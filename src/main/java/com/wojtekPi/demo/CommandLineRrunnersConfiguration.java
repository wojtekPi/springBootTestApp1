package com.wojtekPi.demo;

import com.wojtekPi.demo.updaterService.RatioResponse;
import com.wojtekPi.demo.updaterService.RatioRetrieverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class CommandLineRrunnersConfiguration {

    @Autowired
    private RatioRetrieverService ratioRetrieverService;

    @Bean
    CommandLineRunner addSomeInitialRecordsJob(CurrencyRatioRepository currencyRatioRepository) {
        return args -> {
            Arrays.asList("USD,PLN,4.1","USD,PLN,4.11", "EUR,PLN,4.3")
                    .stream()
                    .forEach(entry -> {
                        String[] values = entry.split(",");
                        currencyRatioRepository.save(new CurrencyRatio(values[0], values[1], LocalDateTime.now(), new BigDecimal(values[2])));
                    });

            currencyRatioRepository.findAll().stream()
                    .forEach(System.out::println);
        };
    }


    @Bean
    CommandLineRunner addSomeInitialRecordsJob2(CurrencyRatioRepository currencyRatioRepository) {
        return args -> {

            while (true){
                RatioResponse responses = ratioRetrieverService.getRatios("USD");
                currencyRatioRepository.save(new CurrencyRatio(responses.getBase(),"ZAR",LocalDateTime.now(),new BigDecimal(responses.getRates().get("ZAR"))));
                Thread.sleep(100000);
            }
        };
    }

}
