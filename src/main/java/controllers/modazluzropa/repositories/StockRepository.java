package controllers.modazluzropa.repositories;

import controllers.modazluzropa.enumns.TipoTalla;
import controllers.modazluzropa.models.Stock;
import controllers.modazluzropa.models.Talla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findByProductoIdAndTalla(Integer idProducto, Talla talla);


}
