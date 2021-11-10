package com.soferian.stocksfinance.data.dao;

import com.soferian.stocksfinance.entity.CommissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionDao extends JpaRepository<CommissionEntity, Long> {
}
