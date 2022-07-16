package com.mabrur.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mabrur.entities.Portfolio;
import com.mabrur.repositories.PortfolioRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {


    private PortfolioRepo portfolioRepo;

    @Override
    public List<Portfolio> getPortfolios() {
        return portfolioRepo.findAll();
    }

    @Override
    public Portfolio savePortfolio(Portfolio portfolio) {
        return portfolioRepo.save(portfolio);
    }

    @Override
    public Portfolio getPortfolio(Long id) {
        return portfolioRepo.getPortfolioById(id);
    }

    @Override
    public void deletePortfolioById(Long id) {
        portfolioRepo.deleteById(id);
    }

    
    
}
