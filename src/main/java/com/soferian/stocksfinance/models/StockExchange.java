package com.soferian.stocksfinance.models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StockExchange {

    private Long id;

    private StockSnapShot stockSnapShot;

    private Integer numOfShares;

    private ExchangeType exchangeType;

    private Double money;

    private Commissions commissions;

    public StockExchange(Long id, StockSnapShot stockSnapShot, Integer numOfShares,
                         ExchangeType exchangeType, Double money, Commissions commissions) {
        this.id = id;
        this.stockSnapShot = stockSnapShot;
        this.numOfShares = numOfShares;
        this.exchangeType = exchangeType;
        this.money = money;
        this.commissions = commissions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commissions getCommissions() {
        return commissions;
    }

    public void setCommissions(Commissions commissions) {
        this.commissions = commissions;
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

    public Double getMoney() {
        return money;
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

    public void setMoney(Double money) {
        this.money = money;
    }

    public void calcMoney() {
        money = numOfShares * stockSnapShot.getStockPrice();
        money = money - commissions.getBuyAndSale() - commissions.getBroker() - commissions.getManagement() - commissions.getCustodian();
        if (exchangeType == ExchangeType.SALE) {
            money = money * (1 - commissions.getCapitalGainTax());
        }
    }
}
