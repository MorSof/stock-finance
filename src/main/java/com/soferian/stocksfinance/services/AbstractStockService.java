package com.soferian.stocksfinance.services;

import com.soferian.stocksfinance.boundary.StockBoundary;
import com.soferian.stocksfinance.boundary.StockExchangeBoundary;

import java.util.List;

public interface AbstractStockService {

    public StockBoundary create(StockBoundary stockBoundary);

    public StockBoundary findById(Long id);

    public List<StockBoundary> findAll();
}
