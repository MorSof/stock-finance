package com.soferian.stocksfinance.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockSnapShot extends Stock {

    private Double stockPrice;

    public StockSnapShot(String stockName, String stockSymbol, Double stockPrice) {
        super(stockName, stockSymbol);
        this.stockPrice = stockPrice;
    }
}
