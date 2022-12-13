package com.project.bootcamp_santander.repository;

import com.project.bootcamp_santander.model.Stock2;
import net.bytebuddy.jar.asm.commons.Remapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/*C*/

@Repository
public interface StockRepository extends JpaRepository<Stock2, Long>{
    Optional<Stock2> findByNameAndDate(String name, LocalDate date);
    @Query("SELECT stock2 FROM Stock2 stock2 WHERE stock2.name = :name AND stock2.date = :date AND stock2.id <> :id ")
    Optional<Stock2> findByStockUpdate(String name, LocalDate date, Long id);

    @Query("SELECT stock2 FROM Stock2 stock2 WHERE stock2.date = :date ")
    Optional<List<Stock2>> findByToday(LocalDate date);
}
