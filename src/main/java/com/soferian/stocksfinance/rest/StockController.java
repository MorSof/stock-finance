package com.soferian.stocksfinance.rest;

import com.soferian.stocksfinance.boundary.StockBoundary;
import com.soferian.stocksfinance.services.AbstractStockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StockController {

    private AbstractStockService abstractStockService;

    @RequestMapping(path = "/stock", method = RequestMethod.POST)
    public StockBoundary create(@RequestBody StockBoundary stockBoundary) {
        return abstractStockService.create(stockBoundary);
    }

    @RequestMapping(path = "/stock/{id}", method = RequestMethod.GET)
    public StockBoundary findById(@PathVariable(value = "id") Long id) {
        return abstractStockService.findById(id);
    }

    @RequestMapping(path = "/stock", method = RequestMethod.GET)
    public List<StockBoundary> findAll() {
        return abstractStockService.findAll();
    }
}
