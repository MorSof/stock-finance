package com.soferian.stocksfinance.rest;

import com.soferian.stocksfinance.models.Stock;
import com.soferian.stocksfinance.services.AbstractStockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class StockController {

    private AbstractStockService abstractStockService;

    @RequestMapping(path = "/stock", method = RequestMethod.POST)
    public Stock create(@RequestBody Stock stock) {
        return abstractStockService.create(stock);
    }

    @RequestMapping(path = "/stock/{id}", method = RequestMethod.GET)
    public Stock findById(@PathVariable(value = "id") Long id) {
        return abstractStockService.findById(id);
    }

    @RequestMapping(path = "/stock", method = RequestMethod.GET)
    public List<Stock> findAll() {
        return abstractStockService.findAll();
    }
}
