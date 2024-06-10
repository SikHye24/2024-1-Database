package com.example.demo.repository;

import com.example.demo.domain.BookEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByIsbnIn(List<Long> isbns);
    @Query("SELECT AVG(b.price) FROM BookEntity b")
    Double findAveragePrice();

    @Query("SELECT b.year, AVG(b.price) FROM BookEntity b GROUP BY b.year ORDER BY b.year")
    List<Object[]> findAveragePriceByYear();

    @Query("SELECT w.name, COUNT(b), MAX(b.price), MIN(b.price), AVG(b.price) " +
            "FROM BookEntity b " +
            "JOIN WrittenByEntity w ON b.isbn = w.isbn " +
            "GROUP BY w.name")
    List<Object[]> findAuthorStatistics();

    @Query("SELECT b FROM BookEntity b WHERE b.price > 0")
    List<BookEntity> findAllWithPositivePrice();

    @Query("SELECT b FROM BookEntity b WHERE b.isbn IN (SELECT s.isbn FROM StockEntity s GROUP BY s.isbn HAVING SUM(s.num) >= :stockThreshold)")
    List<BookEntity> findBooksByStockThreshold(int stockThreshold);

    @Modifying
    @Transactional
    @Query("UPDATE BookEntity b SET b.price = b.price * :discount WHERE b.isbn IN (SELECT s.isbn FROM StockEntity s GROUP BY s.isbn HAVING SUM(s.num) >= :stockThreshold)")
    void applyDiscountToBooksByStockThreshold(int stockThreshold, double discount);
}