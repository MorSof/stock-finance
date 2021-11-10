package com.soferian.stocksfinance.data.dao;

import com.soferian.stocksfinance.entity.StockExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockExchangeDao extends JpaRepository<StockExchangeEntity, Long> {

    @Query("SELECT SUM (money) FROM StockExchangeEntity")
    Long totalProfit();
}
