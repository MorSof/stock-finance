package com.soferian.stocksfinance.util.converters;

import com.soferian.stocksfinance.entity.StockEntity;
import com.soferian.stocksfinance.entity.StockExchangeEntity;
import com.soferian.stocksfinance.models.StockExchange;
import com.soferian.stocksfinance.models.StockSnapShot;
import org.springframework.stereotype.Component;

@Component
public class StockExchangeConverter {

    public StockExchange fromEntity(StockExchangeEntity stockExchangeEntity) {
        StockSnapShot stockSnapShot = new StockSnapShot(stockExchangeEntity.getStock().getStockName(), stockExchangeEntity.getStock().getStockSymbol(), stockExchangeEntity.getStockPrice());
        return new StockExchange(stockSnapShot, stockExchangeEntity.getNumOfShares(), stockExchangeEntity.getExchangeType());
    }

    public StockExchangeEntity toEntity(StockExchange stockExchange) {
        StockExchangeEntity stockExchangeEntity = new StockExchangeEntity();
        stockExchangeEntity.setStockPrice(stockExchange.getStockSnapShot().getStockPrice());
        stockExchangeEntity.setStock(new StockEntity(
                stockExchange.getStockSnapShot().getStockSymbol(),
                stockExchange.getStockSnapShot().getStockName())
        );
        stockExchangeEntity.setNumOfShares(stockExchange.getNumOfShares());
        stockExchangeEntity.setExchangeType(stockExchange.getExchangeType());
        stockExchangeEntity.setProfit(stockExchange.getProfit());
        return stockExchangeEntity;
    }
}
