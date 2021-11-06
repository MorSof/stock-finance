package com.soferian.stocksfinance.util.converters;

import com.soferian.stocksfinance.entity.StockEntity;
import com.soferian.stocksfinance.entity.StockExchangeEntity;
import com.soferian.stocksfinance.boundary.StockExchangeBoundary;
import com.soferian.stocksfinance.models.Stock;
import com.soferian.stocksfinance.models.StockExchange;
import com.soferian.stocksfinance.models.StockSnapShot;
import org.springframework.stereotype.Component;

@Component
public class StockExchangeConverter {

    public StockExchangeBoundary fromEntity(StockExchangeEntity stockExchangeEntity) {
        StockSnapShot stockSnapShot = new StockSnapShot(stockExchangeEntity.getStock().getStockName(), stockExchangeEntity.getStock().getStockSymbol(), stockExchangeEntity.getStockPrice());
        StockExchange stockExchange = new StockExchange(stockSnapShot, stockExchangeEntity.getNumOfShares(), stockExchangeEntity.getExchangeType());
        return new StockExchangeBoundary(stockExchangeEntity.getId(), stockExchange);
    }

    public StockExchangeEntity toEntity(StockExchangeBoundary stockExchangeBoundary) {
        StockExchangeEntity stockExchangeEntity = new StockExchangeEntity();
        stockExchangeEntity.setStockPrice(stockExchangeBoundary.getStockExchange().getStockSnapShot().getStockPrice());
        stockExchangeEntity.setStock(new StockEntity(
                stockExchangeBoundary.getStockExchange().getStockSnapShot().getStockSymbol(),
                stockExchangeBoundary.getStockExchange().getStockSnapShot().getStockName())
        );
        stockExchangeEntity.setNumOfShares(stockExchangeBoundary.getStockExchange().getNumOfShares());
        stockExchangeEntity.setExchangeType(stockExchangeBoundary.getStockExchange().getExchangeType());
        stockExchangeEntity.setProfit(stockExchangeBoundary.getStockExchange().getProfit());
        return stockExchangeEntity;
    }
}
