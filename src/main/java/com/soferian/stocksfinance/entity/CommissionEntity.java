package com.soferian.stocksfinance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Commissions")
@NoArgsConstructor
@Getter
@Setter
public class CommissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Float buyAndSale;

    private Float broker;

    private Float management;

    private Float custodian;

    private Float capitalGainTax;

    @OneToOne(mappedBy = "commission", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private StockExchangeEntity stockExchangeEntity;

    public CommissionEntity(Float buyAndSale, Float broker, Float management, Float custodian, Float capitalGainTax) {
        this.buyAndSale = buyAndSale;
        this.broker = broker;
        this.management = management;
        this.custodian = custodian;
        this.capitalGainTax = capitalGainTax;
    }
}
