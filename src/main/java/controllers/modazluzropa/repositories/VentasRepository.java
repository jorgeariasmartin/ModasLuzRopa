package controllers.modazluzropa.repositories;

import controllers.modazluzropa.models.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepository extends JpaRepository<Ventas, Integer> {
}
