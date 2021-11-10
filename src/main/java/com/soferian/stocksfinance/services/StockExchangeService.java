package com.soferian.stocksfinance.services;

import com.soferian.stocksfinance.data.dao.CommissionDao;
import com.soferian.stocksfinance.data.dao.StockDao;
import com.soferian.stocksfinance.entity.CommissionEntity;
import com.soferian.stocksfinance.entity.StockEntity;
import com.soferian.stocksfinance.entity.StockExchangeEntity;
import com.soferian.stocksfinance.models.StockExchange;
import com.soferian.stocksfinance.util.converters.StockConverter;
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
    private CommissionDao commissionDao;
    private StockExchangeConverter stockExchangeConverter;
    private StockConverter stockConverter;

    @Override
    public StockExchange create(StockExchange stockExchange) {
        stockExchange.calcMoney();
        StockEntity stockEntity = stockDao.findByStockNameOrStockSymbol(stockExchange.getStockSnapShot().getStockName(), stockExchange.getStockSnapShot().getStockSymbol());
        if (stockEntity == null) {
            stockEntity = stockDao.save(stockConverter.toEntity(stockExchange.getStockSnapShot()));
        }
        StockExchangeEntity stockExchangeEntity = stockExchangeConverter.toEntity(stockExchange);
        CommissionEntity commissionEntity = commissionDao.save(stockExchangeEntity.getCommission());
        stockExchangeEntity.setStock(stockEntity);
        stockExchangeEntity.setCommission(commissionEntity);
        return stockExchangeConverter.fromEntity(stockExchangeDao.save(stockExchangeEntity));
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
