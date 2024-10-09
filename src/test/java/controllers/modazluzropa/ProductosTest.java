package controllers.modazluzropa;

import controllers.modazluzropa.models.Productos;
import controllers.modazluzropa.services.ProductosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductosTest {

    @Autowired
    private ProductosService productosService;

    @Test
    void testCrearProducto() {
        Productos producto = new Productos();
        producto.setNombre("Blusa");
        producto.setColor("FFFFFF");
       // Productos productoGuardado = productosService.guardar(producto);
        //System.out.println(productoGuardado.toString());
    }

    @Test
    void editarProducto() {
        Productos producto = productosService.getById(4);
        producto.setColor("000000");
       // Productos productoGuardado = productosService.guardar(producto);
        //System.out.println(productoGuardado.toString());
    }

    @Test
    void eliminarProducto() {
        productosService.eliminar(4);
    }

    @Test
    void buscarTodosProductos() {
        for (Productos producto : productosService.getAll()) {
            System.out.println(producto.toString());
        }
    }
}
