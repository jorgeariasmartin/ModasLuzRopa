package controllers.modazluzropa.repositories;

import controllers.modazluzropa.models.Productos;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    Optional<Productos> findByNombre(String nombre);

}
