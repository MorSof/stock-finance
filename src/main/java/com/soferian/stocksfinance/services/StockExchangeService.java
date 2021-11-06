package com.soferian.stocksfinance.services;

import com.soferian.stocksfinance.data.dao.StockDao;
import com.soferian.stocksfinance.entity.StockExchangeEntity;
import com.soferian.stocksfinance.models.StockExchange;
import com.soferian.stocksfinance.util.converters.StockExchangeConverter;
import com.soferian.stocksfinance.data.dao.StockExchangeDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StockExchangeService implements AbstractStockExchangeService {

    private StockExchangeDao stockExchangeDao;
    private StockDao stockDao;
    private StockExchangeConverter stockExchangeConverter;

    @Override
    public StockExchange create(StockExchange stockExchange) {
        StockExchangeEntity stockExchangeEntity = stockExchangeDao.save(stockExchangeConverter.toEntity(stockExchange));
        return stockExchangeConverter.fromEntity(stockExchangeEntity);
    }

    @Override
    public StockExchange findById(Long id) {
        return stockExchangeConverter.fromEntity(stockExchangeDao.getById(id));
    }

    @Override
    public List<StockExchange> findAll() {
        return stockExchangeDao.findAll().stream().map(this.stockExchangeConverter::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Long totalProfit() {
        return stockExchangeDao.totalProfit();
    }
}
