package controllers.modazluzropa.dtos;

import java.util.List;
import lombok.Data;

@Data
public class VentaDTO {
    private int clienteId;
    private List<DetalleVentaDTO> detallesVenta;
}