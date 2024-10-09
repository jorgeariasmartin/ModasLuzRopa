package controllers.modazluzropa.dtos;

import controllers.modazluzropa.enumns.TipoTalla;
import lombok.Data;

@Data
public class TallaDTO {
    private Integer id;
    private TipoTalla tipoTalla;
    private String descripcion;
}
