package com.soferian.stocksfinance.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StockSnapShot extends Stock {

    private Double stockPrice;

    public StockSnapShot(String stockName, String stockSymbol, Double stockPrice) {
        super(stockName, stockSymbol);
        this.stockPrice = stockPrice;
    }

    public StockSnapShot(Long id, String stockName, String stockSymbol, Double stockPrice) {
        super(id, stockName, stockSymbol);
        this.stockPrice = stockPrice;
    }
}
