package controllers.modazluzropa.repositories;

import controllers.modazluzropa.models.Cliente;
import controllers.modazluzropa.models.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {
    List<Ventas> findByClienteId(int clienteId);
}
