package com.soferian.stocksfinance.boundary;

import com.soferian.stocksfinance.models.StockExchange;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class StockExchangeBoundary {

    private Long id;

    private StockExchange stockExchange;
}
