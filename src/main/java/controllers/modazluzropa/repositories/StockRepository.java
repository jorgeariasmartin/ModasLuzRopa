package controllers.modazluzropa.repositories;

import controllers.modazluzropa.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}
