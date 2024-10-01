package controllers.modazluzropa;

import controllers.modazluzropa.models.Cliente;
import controllers.modazluzropa.models.Ventas;
import controllers.modazluzropa.services.ClienteService;
import controllers.modazluzropa.services.VentasService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class VentasTest {

    @Autowired
    private VentasService ventasService;

    @Autowired
    private ClienteService clienteService;

    @Test
    void testCrearVenta() {
        Ventas venta = new Ventas();
        Cliente cliente = clienteService.getById(3);
        venta.setCliente(cliente);
        venta.setFecha(LocalDate.of(2024, 7, 3).atTime(16,30,0));
        Ventas ventaGuardada = ventasService.guardar(venta);
        System.out.println(ventaGuardada.toString());
    }

    @Test
    void editarVenta() {
        Ventas venta = ventasService.getById(4);
        Cliente cliente = clienteService.getById(2);
        venta.setCliente(cliente);
        Ventas ventaGuardada = ventasService.guardar(venta);
        System.out.println(ventaGuardada.toString());
    }

    @Test
    void eliminarVenta() {
        ventasService.eliminar(4);
    }

    @Test
    void buscarTodasVentas() {
        for (Ventas venta : ventasService.getAll()) {
            System.out.println(venta.toString());
        }
    }
}
