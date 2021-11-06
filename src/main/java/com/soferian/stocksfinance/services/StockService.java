package com.soferian.stocksfinance.services;

import com.soferian.stocksfinance.data.dao.StockDao;
import com.soferian.stocksfinance.entity.StockEntity;
import com.soferian.stocksfinance.exceptions.BadRequestException;
import com.soferian.stocksfinance.models.Stock;
import com.soferian.stocksfinance.util.converters.StockConverter;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StockService implements AbstractStockService{

    private StockDao stockDao;
    private StockConverter stockConverter;

    @Override
    public Stock create(Stock stock) {
        StockEntity stockEntity;
        try {
            stockEntity = stockDao.save(stockConverter.toEntity(stock));
        } catch (DataIntegrityViolationException e) {
            System.out.println(e);
            throw new BadRequestException("The company already exists in the system");
        }
        return stockConverter.fromEntity(stockEntity);
    }

    @Override
    public Stock findById(Long id) {
        return stockConverter.fromEntity(stockDao.getById(id));
    }

    @Override
    public List<Stock> findAll() {
        return stockDao.findAll().stream().map(this.stockConverter::fromEntity).collect(Collectors.toList());
    }
}
