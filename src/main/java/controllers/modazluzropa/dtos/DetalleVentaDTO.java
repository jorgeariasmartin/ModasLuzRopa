package controllers.modazluzropa.dtos;

import lombok.Data;

@Data
public class DetalleVentaDTO {
    private int productoId;
    private int tallaId;
    private int cantidadVendida;
    private double precioUnitario;
}