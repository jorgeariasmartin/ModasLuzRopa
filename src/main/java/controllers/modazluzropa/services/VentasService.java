package controllers.modazluzropa.services;

import controllers.modazluzropa.dtos.VentaDTO;
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
     * @param dto
     * @return
     */
    public Ventas guardar(VentaDTO dto) {
        Ventas ventaGuardar = new Ventas();

        ventaGuardar.setCliente(dto.getCliente());
        ventaGuardar.setFecha(dto.getFecha());
        return ventasRepository.save(ventaGuardar);
    }

    /**
     * Elimina una venta por ID.
     * @param id
     */
    public String eliminar(Integer id) {
        try {
            ventasRepository.deleteById(id);
            return "Venta eliminada";
        } catch (Exception e){
            return "No se ha podido eliminar la venta";
        }
    }

    /**
     * Elimina una venta.
     * @param venta
     */
    public void eliminar(Ventas venta) {
        ventasRepository.delete(venta);
    }
}
