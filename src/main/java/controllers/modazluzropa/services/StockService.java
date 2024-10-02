package controllers.modazluzropa.services;

import controllers.modazluzropa.models.Stock;
import controllers.modazluzropa.repositories.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StockService {

    private StockRepository stockRepository;


    /**
     * Devuelve todos los productos.
     * @return
     */
    public List<Stock> getAll(){
        return stockRepository.findAll();
    }

    /**
     * Devuelve un producto por ID.
     * @param id
     * @return
     */
    public Stock getById(Integer id) {
        return stockRepository.findById(id).orElse(null);
    }

    /**
     * Crea o edita un producto.
     * @param stock
     * @return
     */
    public Stock guardar(Stock stock) {
        return stockRepository.save(stock);
    }

    /**
     * Elimina un producto por ID.
     * @param id
     */
    public void eliminar(Integer id){
        stockRepository.deleteById(id);
    }

    /**
     * Elimina un producto.
     * @param stock
     */
    public void eliminar(Stock stock){
        stockRepository.delete(stock);
    }
}
