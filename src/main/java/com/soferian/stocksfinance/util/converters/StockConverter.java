package com.soferian.stocksfinance.util.converters;

import com.soferian.stocksfinance.entity.StockEntity;
import com.soferian.stocksfinance.models.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockConverter {

    public Stock fromEntity(StockEntity stockEntity) {
        return new Stock(stockEntity.getId(), stockEntity.getStockName(), stockEntity.getStockSymbol());
    }

    public StockEntity toEntity(Stock stock) {
        return new StockEntity(stock.getStockName(), stock.getStockSymbol());
    }

}
