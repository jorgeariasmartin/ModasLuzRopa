package controllers.modazluzropa;

import controllers.modazluzropa.dtos.DetalleVentaDTO;
import controllers.modazluzropa.dtos.VentaDTO;
import controllers.modazluzropa.enumns.TipoTalla;
import controllers.modazluzropa.models.Cliente;
import controllers.modazluzropa.models.Productos;
import controllers.modazluzropa.models.Talla;
import controllers.modazluzropa.models.Ventas;
import controllers.modazluzropa.repositories.ClienteRepository;
import controllers.modazluzropa.repositories.ProductosRepository;
import controllers.modazluzropa.repositories.TallaRepository;
import controllers.modazluzropa.repositories.VentasRepository;
import controllers.modazluzropa.services.VentasService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VentaIntegrationTest {

    @InjectMocks
    private VentasService ventasService;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ProductosRepository productosRepository;

    @Mock
    private TallaRepository tallaRepository;

    @Mock
    private VentasRepository ventasRepository;

    public VentaIntegrationTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTotalPedidosClienteNegativo() {
        // GIVEN
        when(clienteRepository.existsById(3)).thenReturn(false);

        // WHEN
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> ventasService.getVentasByClienteId(3));

        // THEN
        assertEquals("Cliente con ID 3 no encontrado", exception.getMessage());
        verify(clienteRepository, times(1)).existsById(3);
        verifyNoInteractions(ventasRepository); // Aseguramos que no interactúa con ventasRepository
    }


    @Test
    void testCrearPedidoNegativo() {
        // GIVEN
        Cliente clienteMock = new Cliente();
        clienteMock.setId(1);
        clienteMock.setNombre("Carlos");
        clienteMock.setApellidos("García");
        clienteMock.setDni("87654321B");
        when(clienteRepository.findById(1)).thenReturn(Optional.of(clienteMock));

        Productos productoMock = new Productos();
        productoMock.setId(1);
        productoMock.setNombre("Pantalón");
        productoMock.setColor("Negro");
        when(productosRepository.findById(1)).thenReturn(Optional.of(productoMock));

        Talla tallaMock = new Talla();
        tallaMock.setId(1);
        tallaMock.setTalla(TipoTalla.L);
        tallaMock.setDescripcion("Talla L");
        when(tallaRepository.findById(1)).thenReturn(Optional.of(tallaMock));

        DetalleVentaDTO detalleVentaDTO = new DetalleVentaDTO();
        detalleVentaDTO.setProductoId(1);
        detalleVentaDTO.setTallaId(1);
        // Cantidad negativa para simular el error
        detalleVentaDTO.setCantidadVendida(-5);
        detalleVentaDTO.setPrecioUnitario(25.50);

        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setClienteId(1);
        ventaDTO.setDetallesVenta(List.of(detalleVentaDTO));

        // WHEN & THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> ventasService.guardar(ventaDTO));
        assertEquals("La cantidad vendida debe ser mayor a 0", exception.getMessage());
        verify(clienteRepository, times(1)).findById(1);
        verify(productosRepository, times(1)).findById(1);
        verify(tallaRepository, times(1)).findById(1);
        verifyNoInteractions(ventasRepository);
    }
}
