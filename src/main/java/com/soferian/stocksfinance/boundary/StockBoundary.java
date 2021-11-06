package com.soferian.stocksfinance.boundary;

import com.soferian.stocksfinance.models.Stock;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StockBoundary {

    private Long id;

    private Stock stock;
}
