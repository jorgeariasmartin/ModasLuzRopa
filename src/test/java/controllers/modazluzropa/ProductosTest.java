package controllers.modazluzropa;

import controllers.modazluzropa.models.Productos;
import controllers.modazluzropa.repositories.ProductosRepository;
import controllers.modazluzropa.services.ProductosService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class ProductosTest {

    @Autowired
    private ProductosService service;

    @Autowired
    private ProductosRepository repository;

    @BeforeEach
    public void inicializarDatos(){
        Productos producto = new Productos();
        producto.setNombre("Camisa");
        producto.setColor("FFFFFF");
        repository.save(producto);

        Productos producto2 = new Productos();
        producto2.setNombre("Pantalon");
        producto2.setColor("FFFFFF");
        repository.save(producto2);
    }


    @Test
    void testFindAllPositivo() {

        //GIVEN

        //WHEN
        List<Productos> productos = service.getAll();
        //THEN
        assertEquals(2, productos.size());
    }

    @Test
    void testBuscarProductoPorNombrePositivo() {
        // GIVEN
        String nombreProducto = "Camisa";

        // WHEN
        Productos productoEncontrado = repository.findByNombre(nombreProducto).orElseThrow(() ->
                new NoSuchElementException("Producto con nombre " + nombreProducto + " no encontrado")
        );

        // THEN
        assertNotNull(productoEncontrado); // Verificamos que el producto no sea nulo
        assertEquals(nombreProducto, productoEncontrado.getNombre()); // Validamos que el nombre sea correcto
        assertEquals("FFFFFF", productoEncontrado.getColor()); // Validamos el color del producto
    }


    @Test
    void testFindAllNegativo() {
        //GIVEN
        repository.deleteAll();

        //WHEN & THEN
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> service.getAll());
        assertEquals("No se han encontrado productos", exception.getMessage());
    }
}
