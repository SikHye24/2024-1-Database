package com.example.demo.repository;

import com.example.demo.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByIsbnIn(List<Long> isbns);
    @Query("SELECT AVG(b.price) FROM BookEntity b")
    Double findAveragePrice();

    @Query("SELECT b.year, AVG(b.price) FROM BookEntity b GROUP BY b.year ORDER BY b.year")
    List<Object[]> findAveragePriceByYear();
}