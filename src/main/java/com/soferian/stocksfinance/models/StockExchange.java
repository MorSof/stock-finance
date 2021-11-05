package com.soferian.stocksfinance.models;

public class StockExchange {

    private StockSnapShot stockSnapShot;

    private Integer numOfShares;

    private ExchangeType exchangeType;

    private Double profit;

    public StockExchange(StockSnapShot stockSnapShot, Integer numOfShares, ExchangeType exchangeType) {
        this.stockSnapShot = stockSnapShot;
        this.numOfShares = numOfShares;
        this.exchangeType = exchangeType;
        calcProfit();
    }

    public StockSnapShot getStockSnapShot() {
        return stockSnapShot;
    }

    public Integer getNumOfShares() {
        return numOfShares;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }

    public Double getProfit() {
        return profit;
    }

    public void setStockSnapShot(StockSnapShot stockSnapShot) {
        this.stockSnapShot = stockSnapShot;
    }

    public void setNumOfShares(Integer numOfShares) {
        this.numOfShares = numOfShares;
    }

    public void setExchangeType(ExchangeType exchangeType) {
        this.exchangeType = exchangeType;
    }

    public void setProfit(Double profit) {
        calcProfit();
    }

    public void calcProfit() {
        this.profit = numOfShares * stockSnapShot.getStockPrice();
        if (ExchangeType.BUY == exchangeType) {
            this.profit *= -1;
        }
    }
}
