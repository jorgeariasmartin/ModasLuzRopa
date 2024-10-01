package controllers.modazluzropa;

import controllers.modazluzropa.models.Cliente;
import controllers.modazluzropa.services.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteTest {

    @Autowired
    private ClienteService clienteService;

    @Test
    void testCrearCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellidos("Perez");
        cliente.setDni("12345678A");
        Cliente clienteGuardado = clienteService.guardar(cliente);
        System.out.println(clienteGuardado.toString());
    }

    @Test
    void editarCliente() {
        Cliente cliente = clienteService.getById(4);
        cliente.setNombre("Alberto");
        cliente.setApellidos("Garcia");
        cliente.setDni("87654321B");
        Cliente clienteGuardado = clienteService.guardar(cliente);
        System.out.println(clienteGuardado.toString());
    }

    @Test
    void eliminarCLiente() {
        clienteService.eliminar(4);
    }

    @Test
    void bucarTodosClientes() {
        for (Cliente cliente : clienteService.getAll()) {
            System.out.println(cliente.toString());
        }
    }
}
