package com.soferian.stocksfinance.util.converters;

import com.soferian.stocksfinance.boundary.StockBoundary;
import com.soferian.stocksfinance.entity.StockEntity;
import com.soferian.stocksfinance.models.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockConverter {

    public StockBoundary fromEntity(StockEntity stockEntity) {
        return new StockBoundary(stockEntity.getId(), new Stock(stockEntity.getStockName(), stockEntity.getStockSymbol()));
    }

    public StockEntity toEntity(StockBoundary stockBoundary) {
        return new StockEntity(stockBoundary.getStock().getStockName(), stockBoundary.getStock().getStockSymbol());
    }

}
