package controllers.modazluzropa.services;

import controllers.modazluzropa.models.Ventas;
import controllers.modazluzropa.repositories.VentasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VentasService {

    private VentasRepository ventasRepository;

    /**
     * Devuelve todas las ventas.
     * @return
     */
    public List<Ventas> getAll(){
        return ventasRepository.findAll();
    }

    /**
     * Devuelve una venta por ID.
     * @param id
     * @return
     */
    public Ventas getById(Integer id) {
        return ventasRepository.findById(id).orElse(null);
    }

    /**
     * Crea o edita una venta.
     * @param venta
     * @return
     */
    public Ventas guardar(Ventas venta) {
        return ventasRepository.save(venta);
    }

    /**
     * Elimina una venta por ID.
     * @param id
     */
    public void eliminar(Integer id) {
        ventasRepository.deleteById(id);
    }

    /**
     * Elimina una venta.
     * @param venta
     */
    public void eliminar(Ventas venta) {
        ventasRepository.delete(venta);
    }
}
