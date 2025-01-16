package controllers.modazluzropa.services;

import controllers.modazluzropa.dtos.StockDTO;
import controllers.modazluzropa.enumns.TipoTalla;
import controllers.modazluzropa.models.Productos;
import controllers.modazluzropa.models.Stock;
import controllers.modazluzropa.models.Talla;
import controllers.modazluzropa.repositories.ProductosRepository;
import controllers.modazluzropa.repositories.StockRepository;
import controllers.modazluzropa.repositories.TallaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class StockService {

    private StockRepository stockRepository;
    private ProductosRepository productoRepository;
    private TallaRepository tallaRepository;


    /**
     * Devuelve todos los productos.
     * @return
     */
    public List<Stock> getAll(){
        return stockRepository.findAll();
    }

    /**
     * Devuelve un producto por ID.
     * Lanza una excepción si no se encuentra.
     *
     * @param id ID del producto.
     * @return Stock del producto.
     * @throws NoSuchElementException si no se encuentra el producto.
     */
    public Stock getById(Integer id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto con ID " + id + " no encontrado"));
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

    /**
     * Devuelve el catálogo de productos.
     * @return List<Stock>
     */
    public List<Stock> getCatalogo(){
        return stockRepository.findAll();
    }

    public ResponseEntity<?> consultarDisponibilidad(Integer idProducto, Talla talla) {
        try {
            Stock stock = stockRepository.findByProductoIdAndTalla(idProducto, talla);
            if (stock == null) {
                return new ResponseEntity<>("No hay productos disponibles", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(stock, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al consultar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> modificarStock(StockDTO stockDTO) {
        try {
            // Buscar el producto por su ID
            Productos producto = productoRepository.findById(stockDTO.getIdProducto())
                    .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

            // Buscar la talla por su ID
            Talla talla = tallaRepository.findById(stockDTO.getIdTalla())
                    .orElseThrow(() -> new EntityNotFoundException("Talla no encontrada"));

            // Buscar el stock correspondiente al producto y la talla
            Stock stock = stockRepository.findByProductoIdAndTalla(producto.getId(), talla);
            if (stock == null) {
                return new ResponseEntity<>("No hay productos disponibles", HttpStatus.NOT_FOUND);
            }

            // Reemplazar la cantidad con el valor nuevo
            stock.setCantidad(stockDTO.getCantidad());
            stockRepository.save(stock);

            return new ResponseEntity<>(stock, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al modificar el stock", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
