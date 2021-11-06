package com.soferian.stocksfinance.services;

import com.soferian.stocksfinance.models.StockExchange;

import java.util.List;

public interface AbstractStockExchangeService {

    public StockExchange create(StockExchange stockExchange);

    public StockExchange findById(Long id);

    public List<StockExchange> findAll();

    Long totalProfit();
}
