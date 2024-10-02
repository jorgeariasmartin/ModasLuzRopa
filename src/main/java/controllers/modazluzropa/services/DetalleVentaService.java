package controllers.modazluzropa.services;

import controllers.modazluzropa.models.DetalleVenta;
import controllers.modazluzropa.repositories.DetalleVentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetalleVentaService {

    private DetalleVentaRepository detalleVentaRepository;

    /**
     * Devuelve todos los productos.
     * @return
     */
    public List<DetalleVenta> getAll(){
        return detalleVentaRepository.findAll();
    }


    /**
     *
     * @param id
     * @return
     */
    public DetalleVenta getById(Integer id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    /**
     *
     * @param detalleVenta
     * @return
     */
    public DetalleVenta guardar(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    /**
     * Elimina un producto por ID.
     * @param id
     */
    public void eliminar(Integer id){
        detalleVentaRepository.deleteById(id);
    }

    /**
     * Elimina un producto.
     * @param detalleVenta
     */
    public void eliminar(DetalleVenta detalleVenta){
        detalleVentaRepository.delete(detalleVenta);
    }
}
