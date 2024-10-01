package controllers.modazluzropa.services;

import controllers.modazluzropa.models.Productos;
import controllers.modazluzropa.repositories.ProductosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductosService {

    private ProductosRepository productosRepository;

    /**
     * Devuelve todos los productos.
     * @return
     */
    public List<Productos> getAll(){
        return productosRepository.findAll();
    }

    /**
     * Devuelve un producto por ID.
     * @param id
     * @return
     */
    public Productos getById(Integer id) {
        return productosRepository.findById(id).orElse(null);
    }

    /**
     * Crea o edita un producto.
     * @param producto
     * @return
     */
    public Productos guardar(Productos producto) {
        return productosRepository.save(producto);
    }

    /**
     * Elimina un producto por ID.
     * @param id
     */
    public void eliminar(Integer id){
        productosRepository.deleteById(id);
    }

    /**
     * Elimina un producto.
     * @param producto
     */
    public void eliminar(Productos producto){
        productosRepository.delete(producto);
    }
}
