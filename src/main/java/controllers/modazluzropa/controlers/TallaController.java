package controllers.modazluzropa.controlers;

import controllers.modazluzropa.dtos.TallaDTO;
import controllers.modazluzropa.models.Talla;
import controllers.modazluzropa.services.TallaService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/talla")
@AllArgsConstructor
public class TallaController {
    private TallaService tallaService;

    @GetMapping("/all")
    public List<Talla> getTallas(){
        return tallaService.getAll();
    }

    @GetMapping
    public Talla getById(@RequestParam Integer id){
        return tallaService.getById(id);
    }

    @PostMapping
    public Talla guardar(@RequestBody TallaDTO talla){
        return tallaService.guardar(talla);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id){
        return tallaService.eliminar(id);
    }
}
