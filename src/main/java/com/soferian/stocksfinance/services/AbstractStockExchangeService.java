package com.soferian.stocksfinance.services;

import com.soferian.stocksfinance.boundary.StockExchangeBoundary;

import java.util.List;

public interface AbstractStockExchangeService {

    public StockExchangeBoundary create(StockExchangeBoundary stockExchangeBoundary);

    public StockExchangeBoundary findById(Long id);

    public List<StockExchangeBoundary> findAll();

    Long totalProfit();
}
