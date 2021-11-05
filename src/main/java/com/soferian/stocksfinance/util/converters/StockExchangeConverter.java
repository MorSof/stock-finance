package com.soferian.stocksfinance.util.converters;

import com.soferian.stocksfinance.entity.StockExchangeEntity;
import com.soferian.stocksfinance.boundary.StockExchangeBoundary;
import com.soferian.stocksfinance.models.StockExchange;
import com.soferian.stocksfinance.models.StockSnapShot;
import org.springframework.stereotype.Component;

@Component
public class StockExchangeConverter {

    public StockExchangeBoundary fromEntity(StockExchangeEntity stockExchangeEntity) {
        StockSnapShot stockSnapShot = new StockSnapShot(stockExchangeEntity.getStockName(), stockExchangeEntity.getStockSymbol(), stockExchangeEntity.getStockPrice());
        StockExchange stockExchange = new StockExchange(stockSnapShot, stockExchangeEntity.getNumOfShares(), stockExchangeEntity.getExchangeType());
        return new StockExchangeBoundary(stockExchangeEntity.getId(), stockExchange);
    }

    public StockExchangeEntity toEntity(StockExchangeBoundary stockExchangeBoundary) {
        StockExchangeEntity stockExchangeEntity = new StockExchangeEntity();
        stockExchangeEntity.setStockPrice(stockExchangeBoundary.getStockExchange().getStockSnapShot().getStockPrice());
        stockExchangeEntity.setStockName(stockExchangeBoundary.getStockExchange().getStockSnapShot().getStockName());
        stockExchangeEntity.setStockSymbol(stockExchangeBoundary.getStockExchange().getStockSnapShot().getStockSymbol());
        stockExchangeEntity.setNumOfShares(stockExchangeBoundary.getStockExchange().getNumOfShares());
        stockExchangeEntity.setExchangeType(stockExchangeBoundary.getStockExchange().getExchangeType());
        stockExchangeEntity.setProfit(stockExchangeBoundary.getStockExchange().getProfit());
        return stockExchangeEntity;
    }
}
