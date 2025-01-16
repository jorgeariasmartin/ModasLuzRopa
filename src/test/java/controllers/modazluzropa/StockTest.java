package controllers.modazluzropa;

import controllers.modazluzropa.enumns.TipoTalla;
import controllers.modazluzropa.models.Productos;
import controllers.modazluzropa.models.Stock;
import controllers.modazluzropa.models.Talla;
import controllers.modazluzropa.repositories.ProductosRepository;
import controllers.modazluzropa.repositories.StockRepository;
import controllers.modazluzropa.repositories.TallaRepository;
import controllers.modazluzropa.services.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.NoSuchElementException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@AutoConfigureTestDatabase
public class StockTest {

    @Autowired
    private StockService service;

    @Autowired
    private StockRepository repository;

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private TallaRepository tallaRepository;

    @BeforeEach
    public void inicializarDatos(){
        Productos producto = new Productos();
        producto.setNombre("Camisa");
        producto.setColor("FFFFFF");
        productosRepository.save(producto);

        Talla talla = new Talla();
        talla.setDescripcion("Talla L");
        talla.setTalla(TipoTalla.L);
        tallaRepository.save(talla);
    }



    // Test para consultar la disponibilidad de un producto segun la talla
    @Test
    void testConsultarDisponibilidadPositivo() {
        //GIVEN
        Stock stock = new Stock();
        stock.setCantidad(10);
        stock.setProducto(productosRepository.findById(1).get());
        stock.setTalla(tallaRepository.findById(1).get());
        //WHEN
        //THEN
        assertEquals(TipoTalla.L, stock.getTalla().getTalla());
    }

    @Test
    void testConsultarDisponibilidadNegativo() {
        //GIVEN

        //WHEN & THEN
        int idInexistente = 999;
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> service.getById(idInexistente));
        assertEquals("Producto con ID " + idInexistente + " no encontrado", exception.getMessage());
    }




}
