package controllers.modazluzropa;

import controllers.modazluzropa.models.*;
import controllers.modazluzropa.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ModazLuzRopaApplicationTests {

    @Autowired
    private ClienteRepository clienteRepositorio;

    @Autowired
    private DetalleVentaRepository detalleVentaRepositorio;

    @Autowired
    private ProductosRepository productosRepositorio;

    @Autowired
    private StockRepository stockRepositorio;

    @Autowired
    private TallaRepository tallaRepositorio;

    @Autowired
    private TallaProductoPrecioRepository tallaProductoPrecioRepositorio;

    @Autowired
    private VentasRepository ventasRepositorio;

    @Test
    void contextLoads() {
        // Me muestra los clientes uno por uno en la consola
        for (Cliente cliente : clienteRepositorio.findAll()) {
            System.out.println(cliente);
        }

        //Me muestra los DetalleVenta uno por uno en la consola
        for (DetalleVenta detalleVenta : detalleVentaRepositorio.findAll()) {
            System.out.println(detalleVenta);
        }

        //Me muestra los Productos uno por uno en la consola
        for (Productos productos : productosRepositorio.findAll()) {
            System.out.println(productos);
        }

        //Me muestra los Stock uno por uno en la consola
        for (Stock stock : stockRepositorio.findAll()) {
            System.out.println(stock);
        }

        //Me muestra los Talla uno por uno en la consola
        for (Talla talla : tallaRepositorio.findAll()) {
            System.out.println(talla);
        }

        //Me muestra los TallaProductoPrecio uno por uno en la consola
        for (TallaProductoPrecio tallaProductoPrecio : tallaProductoPrecioRepositorio.findAll()) {
            System.out.println(tallaProductoPrecio);
        }

        //Me muestra los Ventas uno por uno en la consola
        for (Ventas ventas : ventasRepositorio.findAll()) {
            System.out.println(ventas);
        }
    }
}
