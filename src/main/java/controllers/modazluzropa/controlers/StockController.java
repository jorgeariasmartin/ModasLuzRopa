package controllers.modazluzropa.controlers;

import controllers.modazluzropa.models.Stock;
import controllers.modazluzropa.models.Talla;
import controllers.modazluzropa.services.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
