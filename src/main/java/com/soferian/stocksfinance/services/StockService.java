package com.soferian.stocksfinance.services;

import com.soferian.stocksfinance.boundary.StockBoundary;
import com.soferian.stocksfinance.boundary.StockBoundary;
import com.soferian.stocksfinance.data.dao.StockDao;
import com.soferian.stocksfinance.data.dao.StockDao;
import com.soferian.stocksfinance.entity.StockEntity;
import com.soferian.stocksfinance.util.converters.StockConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StockService implements AbstractStockService{

    private StockDao stockDao;
    private StockConverter stockConverter;

    @Override
    public StockBoundary create(StockBoundary stockBoundary) {
        StockEntity stockEntity = stockDao.save(stockConverter.toEntity(stockBoundary));
        return stockConverter.fromEntity(stockEntity);
    }

    @Override
    public StockBoundary findById(Long id) {
        return stockConverter.fromEntity(stockDao.getById(id));
    }

    @Override
    public List<StockBoundary> findAll() {
        return stockDao.findAll().stream().map(this.stockConverter::fromEntity).collect(Collectors.toList());
    }

}
