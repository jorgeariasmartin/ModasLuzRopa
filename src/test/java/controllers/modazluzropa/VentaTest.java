package controllers.modazluzropa;

import controllers.modazluzropa.dtos.DetalleVentaDTO;
import controllers.modazluzropa.dtos.VentaDTO;
import controllers.modazluzropa.enumns.TipoTalla;
import controllers.modazluzropa.models.*;
import controllers.modazluzropa.repositories.*;
import controllers.modazluzropa.services.DetalleVentaService;
import controllers.modazluzropa.services.VentasService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase

public class VentaTest {

    @Autowired
    private VentasService service;

    @Autowired
    private DetalleVentaRepository repository;

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TallaRepository tallaRepository;

    @BeforeEach
    public void inicializarDatos(){

        Productos producto = new Productos();
        producto.setNombre("Camisa");
        producto.setColor("FFFFFF");
        productosRepository.save(producto);

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("Juan");
        cliente.setApellidos("Perez");
        cliente.setDni("12345678A");
        clienteRepository.save(cliente);

        Talla talla = new Talla();
        talla.setTalla(TipoTalla.M);
        talla.setDescripcion("Mediana");
        tallaRepository.save(talla);

        Ventas venta = new Ventas();
        venta.setCliente(cliente);
        venta.setFecha(LocalDateTime.now());
        venta.setDetallesVenta(null);

        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setProducto(producto);
        detalleVenta.setTalla(talla);
        detalleVenta.setCantidadVendida(2);
        detalleVenta.setPrecioUnitario(10.0);
        detalleVenta.setVenta(venta);

        ventasRepository.save(venta);

    }

    @Test
    void testTotalPedidosClientePositivo() {
        //GIVEN

        //WHEN
        List<Ventas> ventasCliente = service.getVentasByClienteId(1);
        //THEN
        assertEquals(2, ventasCliente.size());

    }

    @Test
    void testTotalPedidosClienteNegativo() {
        //GIVEN

        //WHEN
        Exception exception = assertThrows(NoSuchElementException.class, () -> service.getVentasByClienteId(3));
        //THEN
        assertEquals(("Cliente con ID " + 3 + " no encontrado"), exception.getMessage());
    }

    @Test
        void testCrearPedidoPositivo() {
        //GIVEN
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellidos("Pérez");
        cliente.setDni("12345678A");
        cliente = clienteRepository.save(cliente);

        Productos producto = new Productos();
        producto.setNombre("Camiseta");
        producto.setColor("Azul");
        producto = productosRepository.save(producto);

        Talla talla = new Talla();
        talla.setTalla(TipoTalla.M);
        talla.setDescripcion("Talla M");
        talla = tallaRepository.save(talla);

        DetalleVentaDTO detalleVentaDTO = new DetalleVentaDTO();
        detalleVentaDTO.setProductoId(producto.getId());
        detalleVentaDTO.setTallaId(talla.getId());
        detalleVentaDTO.setCantidadVendida(2);
        detalleVentaDTO.setPrecioUnitario(19.99);

        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setClienteId(cliente.getId());
        ventaDTO.setDetallesVenta(List.of(detalleVentaDTO));

        //WHEN
        Ventas ventaGuardada = service.guardar(ventaDTO);

        //THEN
        assertNotNull(ventaGuardada);
        assertEquals(cliente.getId(), ventaGuardada.getCliente().getId());
        assertEquals(1, ventaGuardada.getDetallesVenta().size());
        DetalleVenta detalleGuardado = ventaGuardada.getDetallesVenta().get(0);
        assertEquals(producto.getId(), detalleGuardado.getProducto().getId());
        assertEquals(talla.getId(), detalleGuardado.getTalla().getId());
        assertEquals(2, detalleGuardado.getCantidadVendida());
        assertEquals(19.99, detalleGuardado.getPrecioUnitario());
    }

    @Test
    void testCrearPedidoCantidadNegativa() {
        // GIVEN
        Cliente cliente = new Cliente();
        cliente.setNombre("Carlos");
        cliente.setApellidos("García");
        cliente.setDni("87654321B");
        cliente = clienteRepository.save(cliente);

        Productos producto = new Productos();
        producto.setNombre("Pantalón");
        producto.setColor("Negro");
        producto = productosRepository.save(producto);

        Talla talla = new Talla();
        talla.setTalla(TipoTalla.L);
        talla.setDescripcion("Talla L");
        talla = tallaRepository.save(talla);

        DetalleVentaDTO detalleVentaDTO = new DetalleVentaDTO();
        detalleVentaDTO.setProductoId(producto.getId());
        detalleVentaDTO.setTallaId(talla.getId());
        detalleVentaDTO.setCantidadVendida(-3); // Cantidad negativa para forzar el fallo
        detalleVentaDTO.setPrecioUnitario(25.50);

        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setClienteId(cliente.getId());
        ventaDTO.setDetallesVenta(List.of(detalleVentaDTO));

        // WHEN & THEN
        Exception exception = assertThrows(RuntimeException.class, () -> service.guardar(ventaDTO));
        assertEquals("La cantidad vendida debe ser mayor a 0", exception.getMessage());
    }

}
