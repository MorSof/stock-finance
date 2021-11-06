package com.soferian.stocksfinance.models;

public class Taxes implements Deduction{

    // in percentage
    private Float capitalGainTax;

    @Override
    public Double deduct(Double amount) {
        return (amount * (100 - capitalGainTax)) / 100;
    }
}
