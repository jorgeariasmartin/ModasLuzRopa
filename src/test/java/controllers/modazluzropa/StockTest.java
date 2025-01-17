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
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class StockTest {

    @Autowired
    private StockService service;

    @Autowired
    private StockRepository repository;

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private TallaRepository tallaRepository;
    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    public void inicializarDatos(){
        Productos producto = new Productos();
        producto.setId(1);
        producto.setNombre("Camisa");
        producto.setColor("FFFFFF");
        productosRepository.save(producto);

        Talla talla = new Talla();
        talla.setId(1);
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
    void testAgregarYConsultarStockPositivo() {
        // GIVEN
        Productos producto = productosRepository.findById(1).get();
        Talla talla = tallaRepository.findById(1).get();

        Stock nuevoStock = new Stock();
        nuevoStock.setCantidad(20);
        nuevoStock.setProducto(producto);
        nuevoStock.setTalla(talla);

        // WHEN
        repository.save(nuevoStock);
        Stock stockGuardado = repository.findById(nuevoStock.getId()).get();

        // THEN
        assertEquals(20, stockGuardado.getCantidad());
        assertEquals(producto.getId(), stockGuardado.getProducto().getId());
        assertEquals(talla.getId(), stockGuardado.getTalla().getId());
        assertEquals(TipoTalla.L, stockGuardado.getTalla().getTalla());
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
