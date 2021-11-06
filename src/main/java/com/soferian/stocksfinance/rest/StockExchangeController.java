package com.soferian.stocksfinance.rest;

import com.soferian.stocksfinance.boundary.StockExchangeBoundary;
import com.soferian.stocksfinance.services.AbstractStockExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StockExchangeController {

    private AbstractStockExchangeService abstractStockExchangeService;

    @RequestMapping(path = "/stock_exchange", method = RequestMethod.POST)
    public StockExchangeBoundary create(@RequestBody StockExchangeBoundary stockExchangeBoundary) {
        return abstractStockExchangeService.create(stockExchangeBoundary);
    }

    @RequestMapping(path = "/stock_exchange/{id}", method = RequestMethod.GET)
    public StockExchangeBoundary findById(@PathVariable(value = "id") Long id) {
        return abstractStockExchangeService.findById(id);
    }

    @RequestMapping(path = "/stock_exchange", method = RequestMethod.GET)
    public List<StockExchangeBoundary> findAll() {
        return abstractStockExchangeService.findAll();
    }

    @RequestMapping(path = "/stock_exchange/totalProfit", method = RequestMethod.GET)
    public Long totalProfit() {
        return abstractStockExchangeService.totalProfit();
    }
}
