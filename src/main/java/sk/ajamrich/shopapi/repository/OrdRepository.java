package sk.ajamrich.shopapi.repository;

import sk.ajamrich.shopapi.entity.Ord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdRepository extends JpaRepository<Ord, Long> {
}