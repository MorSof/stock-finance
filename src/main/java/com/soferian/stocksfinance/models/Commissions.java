package com.soferian.stocksfinance.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Commissions {

    private Float buyAndSale;

    private Float broker;

    private Float management;

    private Float custodian;

    private Float capitalGainTax;
}
