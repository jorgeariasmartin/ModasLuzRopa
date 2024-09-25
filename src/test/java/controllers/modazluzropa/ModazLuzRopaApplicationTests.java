package controllers.modazluzropa;

import controllers.modazluzropa.models.Cliente;
import controllers.modazluzropa.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ModazLuzRopaApplicationTests {

    @Autowired
    private ClienteRepository clienteRepositorio;

    @Test
    void contextLoads() {
    // Me muestra los clientes uno por uno en la consola
        for (Cliente cliente : clienteRepositorio.findAll()) {
            System.out.println(cliente);
        }
    }
}
