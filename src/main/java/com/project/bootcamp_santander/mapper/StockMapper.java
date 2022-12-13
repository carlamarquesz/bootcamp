package com.project.bootcamp_santander.mapper;

import com.project.bootcamp_santander.model.Stock2;
import com.project.bootcamp_santander.model.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {
    public Stock2 toEntity(StockDTO dto) {
        Stock2 stock2 = new Stock2();
        stock2.setId(dto.getId());
        stock2.setName(dto.getName());
        stock2.setPrice(dto.getPrice());
        stock2.setVariation(dto.getVariation());
        stock2.setDate(dto.getDate());
        return stock2;
    }

    public StockDTO toDto(Stock2 stock2) {
        StockDTO dto = new StockDTO();
        dto.setId(stock2.getId());
        dto.setName(stock2.getName());
        dto.setPrice(stock2.getPrice());
        dto.setVariation(stock2.getVariation());
        dto.setDate(stock2.getDate());
        return dto;
    }
    public List<StockDTO> toDto(List<Stock2> listStock2){
        return listStock2.stream().map(this::toDto).collect(Collectors.toList());
    }
}
