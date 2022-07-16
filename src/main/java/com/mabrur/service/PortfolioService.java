package com.mabrur.service;

import java.util.List;

import com.mabrur.entities.Portfolio;


public interface PortfolioService {

    List<Portfolio> getPortfolios();
    Portfolio savePortfolio(Portfolio portfolio);
    Portfolio getPortfolio(Long id);
    void deletePortfolioById(Long id);
}
