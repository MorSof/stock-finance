package com.soferian.stocksfinance.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Commissions implements Deduction{

    private Float buyAndSale;

    private Float broker;

    private Float management;

    private Float custodian;

    @Override
    public Double deduct(Double amount) {
        return amount - buyAndSale - broker - management - custodian;
    }
}
