package controllers.modazluzropa.dtos;

import controllers.modazluzropa.models.Cliente;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VentaDTO {
    private Integer id;
    private Cliente cliente;
    private LocalDateTime fecha;
}
