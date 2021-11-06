package com.soferian.stocksfinance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Stocks")
@NoArgsConstructor
@Getter
@Setter
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique=true)
    private String stockName;

    @Column(unique=true)
    private String stockSymbol;

    @OneToMany(mappedBy = "stock", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<StockExchangeEntity> stockExchangeEntities;

    public StockEntity(String stockName, String stockSymbol) {
        this.stockName = stockName;
        this.stockSymbol = stockSymbol;
    }
}
