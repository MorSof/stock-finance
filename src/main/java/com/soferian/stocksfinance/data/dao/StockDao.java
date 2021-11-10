package com.soferian.stocksfinance.data.dao;

import com.soferian.stocksfinance.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao extends JpaRepository<StockEntity, Long> {

    StockEntity findByStockNameOrStockSymbol(@Param("stockName") String stockName, @Param("stockSymbol") String stockSymbol);
}
