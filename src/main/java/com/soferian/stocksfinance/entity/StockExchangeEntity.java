package com.soferian.stocksfinance.entity;

import com.soferian.stocksfinance.models.ExchangeType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="StockExchanges")
@Getter
@Setter
public class StockExchangeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String stockName;

    private String stockSymbol;

    private Double stockPrice;

    private Integer numOfShares;

    private ExchangeType exchangeType;

    @Column(name = "profit")
    private Double profit;
}
