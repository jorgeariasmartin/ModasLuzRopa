package controllers.modazluzropa.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
    private Integer idProducto;
    private Integer idTalla;
    private Integer cantidad;

}
