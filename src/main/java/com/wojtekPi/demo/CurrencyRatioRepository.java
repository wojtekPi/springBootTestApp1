package com.wojtekPi.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface CurrencyRatioRepository extends JpaRepository<CurrencyRatio, Long> {
    Collection<CurrencyRatio> findDistinctFirstByCurrencyFromAndAndCurrencyToOrderByDateOfCheckDesc(@Param("currencyFrom") String currencyFrom, @Param("currencyTo") String currencyTo);
    @Query(value = "select cr from CurrencyRatio cr order by cr.dateOfCheck desc")
    Collection<CurrencyRatio> getAvailableRatios();
}
