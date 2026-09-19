package sk.ajamrich.shopapi.repository;

import sk.ajamrich.shopapi.entity.Ord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrdRepository extends JpaRepository<Ord, Long> {

    @Query("SELECT o FROM Ord o WHERE " +
            "(CAST(:search AS string) IS NULL OR LOWER(o.ordnum) LIKE LOWER(CONCAT('%', CAST(:search AS string), '%'))) AND " +
            "(CAST(:dateFrom AS timestamp) IS NULL OR o.createdAt >= :dateFrom) AND " +
            "(CAST(:dateTo AS timestamp) IS NULL OR o.createdAt <= :dateTo) " +
            "ORDER BY o.id DESC")
    List<Ord> search(
            @Param("search") String search,
            @Param("dateFrom") LocalDateTime dateFrom,
            @Param("dateTo") LocalDateTime dateTo
    );
}