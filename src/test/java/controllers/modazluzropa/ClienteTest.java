package controllers.modazluzropa;

import controllers.modazluzropa.models.Cliente;
import controllers.modazluzropa.repositories.ClienteRepository;
import controllers.modazluzropa.services.ClienteService;
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
public class ClienteTest {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteRepository repository;

    @BeforeEach
    public void inicializarDatos(){
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellidos("Perez Gamero");
        cliente.setDni("12345678H");
        repository.save(cliente);
    }

    @Test
    void testEliminarClientePositivo() {
        //GIVEN
        Cliente cliente = repository.findById(1).get();

        //WHEN
        service.eliminar(cliente);

        //THEN
        assertEquals(0, repository.count());
    }

    @Test
    void testEliminarClienteNegativo() {
        //GIVEN

        //WHEN & THEN
        int idInexistente = 999;
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> service.eliminar(idInexistente));
        assertEquals("Cliente con ID " + idInexistente + " no encontrado", exception.getMessage());
    }
}
