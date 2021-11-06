package com.soferian.stocksfinance.entity;

import com.soferian.stocksfinance.models.ExchangeType;
import com.soferian.stocksfinance.models.Stock;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="StockExchanges")
@Getter
@Setter
public class StockExchangeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private StockEntity stock;

    private Double stockPrice;

    private Integer numOfShares;

    private ExchangeType exchangeType;

    private Double profit;
}
