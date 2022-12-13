package com.project.bootcamp_santander.service;
/*Classe que vai atender a entidade negocial do Stock (Regra de negócio)*/

import com.project.bootcamp_santander.exceptions.BusinessException;
import com.project.bootcamp_santander.exceptions.NotFoundException;
import com.project.bootcamp_santander.mapper.StockMapper;
import com.project.bootcamp_santander.model.Stock2;
import com.project.bootcamp_santander.model.dto.StockDTO;
import com.project.bootcamp_santander.repository.StockRepository;
import com.project.bootcamp_santander.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock2> optionalStock2 = repository.findByNameAndDate(dto.getName(), dto.getDate());
        if (optionalStock2.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock2 stock2 = mapper.toEntity(dto);
        repository.save(stock2);
        dto.setId(stock2.getId());
        return mapper.toDto(stock2);
    }
    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock2> optionalStock2 = repository.findByStockUpdate(dto.getName(), dto.getDate(),dto.getId());
        if (optionalStock2.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock2 stock2 = mapper.toEntity(dto);
        repository.save(stock2);
        return mapper.toDto(stock2);
    }
    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);
        repository.deleteById(dto.getId());
        return dto;
    }
    @Transactional
    public List<StockDTO> findALL() {
        return mapper.toDto(repository.findAll());
    }
    @Transactional
    public StockDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }
    @Transactional
    public List<StockDTO> findByToday() {
        return repository.findByToday(LocalDate.now()).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

}
