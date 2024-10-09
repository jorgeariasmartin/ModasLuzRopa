package controllers.modazluzropa;

import controllers.modazluzropa.enumns.TipoTalla;
import controllers.modazluzropa.models.Talla;
import controllers.modazluzropa.services.TallaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TallaTest {

    @Autowired
    private TallaService tallaService;

    @Test
    void testCrearTalla() {
        Talla talla = new Talla();
        talla.setTalla(TipoTalla.M);
        talla.setDescripcion("Mediana");
       // Talla tallaguardada = tallaService.guardar(talla);
       // System.out.println(tallaguardada.toString());
    }

    @Test
    void editarTalla() {
        Talla talla = tallaService.getById(4);
        talla.setTalla(TipoTalla.L);
        talla.setDescripcion("Grande");
       // Talla tallaGuardada = tallaService.guardar(talla);
       // System.out.println(tallaGuardada.toString());
    }

    @Test
    void eliminarTalla() {
        tallaService.eliminar(4);
    }

    @Test
    void buscarTodasTallas() {
        for (Talla talla : tallaService.getAll()) {
            System.out.println(talla.toString());
        }
    }
}
