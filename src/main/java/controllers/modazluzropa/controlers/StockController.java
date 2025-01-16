package controllers.modazluzropa.controlers;

import controllers.modazluzropa.dtos.StockDTO;
import controllers.modazluzropa.models.Stock;
import controllers.modazluzropa.models.Talla;
import controllers.modazluzropa.services.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@AllArgsConstructor
public class StockController {
    private StockService stockService;

    @GetMapping("/catalogo")
    public List<Stock> getCatalogo(){
        return stockService.getCatalogo();
    }

    @GetMapping("/disponibilidad")
    public ResponseEntity<?> consultarDisponibilidad(@RequestParam Integer idProducto, @RequestParam Talla talla) {
        return stockService.consultarDisponibilidad(idProducto, talla);
    }

    @PostMapping("/modificar")
    public ResponseEntity<?> modificarStock(@RequestBody StockDTO stockDTO) {
        return stockService.modificarStock(stockDTO);
    }
}
