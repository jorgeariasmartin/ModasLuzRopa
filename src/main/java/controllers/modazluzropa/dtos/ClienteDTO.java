package controllers.modazluzropa.dtos;

import lombok.Data;

@Data
public class ClienteDTO {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String dni;
}
