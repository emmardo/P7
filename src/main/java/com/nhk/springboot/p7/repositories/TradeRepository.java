package com.nhk.springboot.p7.repositories;

import com.nhk.springboot.p7.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TradeRepository extends JpaRepository<Trade, Integer> {
}
