package com.mabrur.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mabrur.entities.Portfolio;

public interface PortfolioRepo extends JpaRepository<Portfolio, Long> {
    
   Portfolio getPortfolioById(Long id);

   void deletePortfolioById(Long id);
}
