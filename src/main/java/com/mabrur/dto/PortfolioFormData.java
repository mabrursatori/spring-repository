package com.mabrur.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioFormData {
    
    private Long id;

    private String title;

    private String label;

    private Integer number;

    private String urlDemo;

    private String urlFirstSource;

    private String urlSecondSource;

    private String urlVideo;

    private String description;

    private String tech;

    private MultipartFile image;
}
