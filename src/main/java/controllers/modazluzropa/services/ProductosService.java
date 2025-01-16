package controllers.modazluzropa.services;

import controllers.modazluzropa.dtos.ProductoDTO;
import controllers.modazluzropa.models.Productos;
import controllers.modazluzropa.repositories.ProductosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProductosService {

    private ProductosRepository productosRepository;

    /**
     * Devuelve todos los productos y si devuelve no encuentra nada tira una excepcion.
     * @return
     */
    public List<Productos> getAll() {
        List<Productos> productos = productosRepository.findAll();
        if (productos.isEmpty()) {
            throw new NoSuchElementException("No se han encontrado productos");
        }
        return productos;
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
     * @param dto
     * @return
     */
    public Productos guardar(ProductoDTO dto) {
        Productos productoGuardar = new Productos();
        productoGuardar.setNombre(dto.getNombre());
        productoGuardar.setColor(dto.getColor());

        return productosRepository.save(productoGuardar);
    }

    /**
     * Elimina un producto por ID.
     * @param id
     */
    public String eliminar(Integer id){
        try {
            productosRepository.deleteById(id);
            return "Producto eliminado";
        } catch (Exception e) {
            return "No se ha podido eliminar el producto";
        }
    }

    /**
     * Elimina un producto.
     * @param producto
     */
    public void eliminar(Productos producto){
        productosRepository.delete(producto);
    }
}
