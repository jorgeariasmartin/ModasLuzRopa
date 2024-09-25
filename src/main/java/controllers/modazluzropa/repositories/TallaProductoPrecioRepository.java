package controllers.modazluzropa.repositories;

import controllers.modazluzropa.models.TallaProductoPrecio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TallaProductoPrecioRepository extends JpaRepository<TallaProductoPrecio, Integer> {
}
