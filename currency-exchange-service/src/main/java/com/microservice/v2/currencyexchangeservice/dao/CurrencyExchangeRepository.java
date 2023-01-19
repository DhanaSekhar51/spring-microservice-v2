package com.microservice.v2.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.v2.currencyexchangeservice.bean.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{

	CurrencyExchange findByFromAndTo(String from, String to);
	
}
