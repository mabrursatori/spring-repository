package com.mabrur;

import java.io.IOException;
import java.util.Optional;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mabrur.dto.PortfolioFormData;
import com.mabrur.entities.Portfolio;
import com.mabrur.service.PortfolioService;

@SpringBootApplication
public class MabrurPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MabrurPortfolioApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper(){
		Converter<PortfolioFormData, Portfolio> portfolioConverter = new AbstractConverter<PortfolioFormData, Portfolio>() {

			@Override
			protected Portfolio convert(PortfolioFormData source) {
				Portfolio portfolio = new Portfolio();
				portfolio.setTitle(source.getTitle());
				portfolio.setId(source.getId());
				portfolio.setLabel(source.getLabel());
				portfolio.setNumber(source.getNumber());
				portfolio.setDescription(source.getDescription());
				portfolio.setTech(source.getTech());
				portfolio.setUrlDemo(source.getUrlDemo());
				portfolio.setUrlFirstSource(source.getUrlFirstSource());
				portfolio.setUrlSecondSource(source.getUrlSecondSource());
				portfolio.setUrlVideo(source.getUrlVideo());
				
				try{
					byte[] byteObjects = new byte[source.getImage().getBytes().length];
					int i = 0;
					for (byte b : source.getImage().getBytes()) {
						byteObjects[i++] = b;
					}
					portfolio.setImage(byteObjects);
				}catch(IOException e){
					return portfolio;
				}
            
				return portfolio;
			}
			
		  };
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(portfolioConverter);
		return modelMapper;
	}

	@Bean
	CommandLineRunner run(PortfolioService portfolioService) {

		Portfolio portfolio = new Portfolio();
		portfolio.setId(1L);
		portfolio.setTitle("Test Title");
		portfolio.setNumber(1);
		portfolio.setLabel("Label test");
		portfolio.setDescription("description");

		return args -> {
			//  portfolioService.savePortfolio(portfolio);
		};
	}

}
