package controllers.modazluzropa.services;

import controllers.modazluzropa.dtos.VentaDTO;
import controllers.modazluzropa.models.*;
import controllers.modazluzropa.repositories.ClienteRepository;
import controllers.modazluzropa.repositories.ProductosRepository;
import controllers.modazluzropa.repositories.TallaRepository;
import controllers.modazluzropa.repositories.VentasRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VentasService {

    private final ClienteRepository clienteRepository;
    private VentasRepository ventasRepository;
    private ProductosRepository productoRepository;
    private TallaRepository tallaRepository;

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
    @Transactional
    public Ventas guardar(VentaDTO dto) {
        // Buscar el cliente
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Crear una nueva venta
        Ventas venta = new Ventas();
        venta.setCliente(cliente);
        venta.setFecha(LocalDateTime.now());

        // Crear los detalles de la venta
        List<DetalleVenta> detallesVenta = dto.getDetallesVenta().stream().map(detalleDTO -> {
            DetalleVenta detalleVenta = new DetalleVenta();

            // Buscar el producto y la talla
            Productos producto = productoRepository.findById(detalleDTO.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            Talla talla = tallaRepository.findById(detalleDTO.getTallaId())
                    .orElseThrow(() -> new RuntimeException("Talla no encontrada"));

            // Setear los valores del detalle de la venta
            detalleVenta.setProducto(producto);
            detalleVenta.setTalla(talla);
            detalleVenta.setCantidadVendida(detalleDTO.getCantidadVendida());
            detalleVenta.setPrecioUnitario(detalleDTO.getPrecioUnitario());
            detalleVenta.setVenta(venta);

            return detalleVenta;
        }).collect(Collectors.toList());

        venta.setDetallesVenta(detallesVenta);

        // Guardar la venta con los detalles
        return ventasRepository.save(venta);
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

    public List<Ventas> getVentasByClienteId(int clienteId) {
        return ventasRepository.findByClienteId(clienteId);
    }
}
