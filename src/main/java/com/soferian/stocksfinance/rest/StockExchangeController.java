package com.soferian.stocksfinance.rest;

import com.soferian.stocksfinance.boundary.StockExchangeBoundary;
import com.soferian.stocksfinance.services.AbstractStockExchangeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockExchangeController {

    private AbstractStockExchangeService abstractStockExchangeService;

    public StockExchangeController(AbstractStockExchangeService abstractStockExchangeService) {
        this.abstractStockExchangeService = abstractStockExchangeService;
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public StockExchangeBoundary create(@RequestBody StockExchangeBoundary stockExchangeBoundary) {
        return abstractStockExchangeService.create(stockExchangeBoundary);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public StockExchangeBoundary findById(@PathVariable(value = "id") Long id) {
        return abstractStockExchangeService.findById(id);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<StockExchangeBoundary> findAll() {
        return abstractStockExchangeService.findAll();
    }

    @RequestMapping(path = "/totalProfit", method = RequestMethod.GET)
    public Long totalProfit() {
        return abstractStockExchangeService.totalProfit();
    }
}
