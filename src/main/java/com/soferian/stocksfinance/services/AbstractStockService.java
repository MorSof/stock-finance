package com.soferian.stocksfinance.services;

import com.soferian.stocksfinance.models.Stock;

import java.util.List;

public interface AbstractStockService {

    public Stock create(Stock stock);

    public Stock findById(Long id);

    public List<Stock> findAll();
}
