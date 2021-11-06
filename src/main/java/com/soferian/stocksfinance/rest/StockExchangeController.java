package com.soferian.stocksfinance.rest;

import com.soferian.stocksfinance.models.StockExchange;
import com.soferian.stocksfinance.services.AbstractStockExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class StockExchangeController {

    private AbstractStockExchangeService abstractStockExchangeService;

    @RequestMapping(path = "/stock_exchange", method = RequestMethod.POST)
    public StockExchange create(@RequestBody StockExchange stockExchange) {
        return abstractStockExchangeService.create(stockExchange);
    }

    @RequestMapping(path = "/stock_exchange/{id}", method = RequestMethod.GET)
    public StockExchange findById(@PathVariable(value = "id") Long id) {
        return abstractStockExchangeService.findById(id);
    }

    @RequestMapping(path = "/stock_exchange", method = RequestMethod.GET)
    public List<StockExchange> findAll() {
        return abstractStockExchangeService.findAll();
    }

    @RequestMapping(path = "/stock_exchange/totalProfit", method = RequestMethod.GET)
    public Long totalProfit() {
        return abstractStockExchangeService.totalProfit();
    }
}
