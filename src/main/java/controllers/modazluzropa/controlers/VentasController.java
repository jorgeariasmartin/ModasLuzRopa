package controllers.modazluzropa.controlers;

import controllers.modazluzropa.dtos.VentaDTO;
import controllers.modazluzropa.models.Ventas;
import controllers.modazluzropa.services.VentasService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@AllArgsConstructor
public class VentasController {
    private VentasService ventasService;

    @GetMapping("/all")
    public List<Ventas> getVentas(){
        return ventasService.getAll();
    }

    @GetMapping
    public Ventas getById(@RequestParam Integer id){
        return ventasService.getById(id);
    }

    @PostMapping("/guardar")
    public Ventas guardar(@RequestBody VentaDTO ventaDTO) {
        return ventasService.guardar(ventaDTO);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id){
        return ventasService.eliminar(id);
    }

    @GetMapping("/cliente/{id}")
    public List<Ventas> getVentasByCliente(@PathVariable("id") int clienteId) {
        return ventasService.getVentasByClienteId(clienteId);
    }
}
