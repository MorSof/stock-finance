package com.soferian.stocksfinance.util.converters;

import com.soferian.stocksfinance.entity.CommissionEntity;
import com.soferian.stocksfinance.entity.StockEntity;
import com.soferian.stocksfinance.entity.StockExchangeEntity;
import com.soferian.stocksfinance.models.Commissions;
import com.soferian.stocksfinance.models.StockExchange;
import com.soferian.stocksfinance.models.StockSnapShot;
import org.springframework.stereotype.Component;

@Component
public class StockExchangeConverter {

    public StockExchange fromEntity(StockExchangeEntity stockExchangeEntity) {
        StockSnapShot stockSnapShot = new StockSnapShot(
                stockExchangeEntity.getStock().getId(),
                stockExchangeEntity.getStock().getStockName(),
                stockExchangeEntity.getStock().getStockSymbol(),
                stockExchangeEntity.getStockPrice()
        );
        Commissions commissions = new Commissions(
                stockExchangeEntity.getCommission().getBuyAndSale(),
                stockExchangeEntity.getCommission().getBroker(),
                stockExchangeEntity.getCommission().getManagement(),
                stockExchangeEntity.getCommission().getCustodian(),
                stockExchangeEntity.getCommission().getCapitalGainTax()
                );
        return new StockExchange(
                stockExchangeEntity.getId(),
                stockSnapShot,
                stockExchangeEntity.getNumOfShares(),
                stockExchangeEntity.getExchangeType(),
                stockExchangeEntity.getMoney(),
                commissions
        );
    }

    public StockExchangeEntity toEntity(StockExchange stockExchange) {
        StockExchangeEntity stockExchangeEntity = new StockExchangeEntity();
        stockExchangeEntity.setStockPrice(stockExchange.getStockSnapShot().getStockPrice());
        stockExchangeEntity.setStock(new StockEntity(
                stockExchange.getStockSnapShot().getStockSymbol(),
                stockExchange.getStockSnapShot().getStockName()
                )
        );
        stockExchangeEntity.setCommission(new CommissionEntity(
                stockExchange.getCommissions().getBuyAndSale(),
                stockExchange.getCommissions().getBroker(),
                stockExchange.getCommissions().getManagement(),
                stockExchange.getCommissions().getCustodian(),
                stockExchange.getCommissions().getCapitalGainTax()
                )
        );
        stockExchangeEntity.setNumOfShares(stockExchange.getNumOfShares());
        stockExchangeEntity.setExchangeType(stockExchange.getExchangeType());
        stockExchangeEntity.setMoney(stockExchange.getMoney());
        return stockExchangeEntity;
    }
}
