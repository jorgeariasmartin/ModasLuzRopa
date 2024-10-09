package controllers.modazluzropa.controlers;

import controllers.modazluzropa.dtos.ProductoDTO;
import controllers.modazluzropa.models.Productos;
import controllers.modazluzropa.services.ProductosService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@AllArgsConstructor
public class ProductoController {

    private ProductosService productosService;

    @GetMapping("/all")
    public List<Productos> getProductos() {
        return productosService.getAll();
    }

    @GetMapping
    public Productos getById(@RequestParam Integer id){
        return productosService.getById(id);
    }

    @PostMapping
    public Productos guardar(@RequestBody ProductoDTO producto){
        return productosService.guardar(producto);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id){
        return productosService.eliminar(id);
    }
}
