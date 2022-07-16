package com.mabrur.controllers;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mabrur.dto.PortfolioFormData;
import com.mabrur.dto.ResponseData;
import com.mabrur.entities.Portfolio;
import com.mabrur.service.PortfolioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/portfolio")
@AllArgsConstructor
public class PortfolioController {
    
    private final PortfolioService portfolioService;

    private final ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<ResponseData<List<Portfolio>>> getPortfolios() {
        
        ResponseData<List<Portfolio>> responseData = new ResponseData<>();
        responseData.setStatus(200);
        responseData.setPayload(portfolioService.getPortfolios());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Portfolio>> getPortfolio(@PathVariable("id") Long id) {
        ResponseData<Portfolio> responseData = new ResponseData<>();
        responseData.setStatus(200);
        responseData.setPayload(portfolioService.getPortfolio(id));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ResponseData<Portfolio>> savePortfolio(PortfolioFormData portfolioFormData){
        Portfolio portfolio = modelMapper.map(portfolioFormData, Portfolio.class);
        ResponseData<Portfolio> responseData = new ResponseData<>();
        responseData.setStatus(200);
        responseData.setPayload(portfolioService.savePortfolio(portfolio));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<Object>> deletePortfolio(@PathVariable("id") Long id){
        portfolioService.deletePortfolioById(1L);
        ResponseData<Object> responseData = new ResponseData<>();
        responseData.setStatus(200);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseData<Portfolio>> updatePortfolio(PortfolioFormData portfolioFormData,@PathVariable("id") Long id) { 
        Portfolio portfolio = modelMapper.map(portfolioFormData, Portfolio.class);
        portfolio.setId(id);
        ResponseData<Portfolio> responseData = new ResponseData<>();
        responseData.setStatus(200);
        responseData.setPayload(portfolioService.savePortfolio(portfolio));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
        Optional<Portfolio> portfolio = Optional.ofNullable(portfolioService.getPortfolio(id));
        if (portfolio.isPresent()) {
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            return new ResponseEntity<byte[]>(portfolio.get().getImage(), headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
