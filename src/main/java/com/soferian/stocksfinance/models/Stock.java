package com.soferian.stocksfinance.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Stock {

    public Stock(String stockName, String stockSymbol) {
        this.stockName = stockName;
        this.stockSymbol = stockSymbol;
    }

    private Long id;

    private String stockName;

    private String stockSymbol;
}
