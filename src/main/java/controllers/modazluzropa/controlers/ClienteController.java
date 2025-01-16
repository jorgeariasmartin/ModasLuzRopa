package controllers.modazluzropa.controlers;

import controllers.modazluzropa.dtos.ClienteDTO;
import controllers.modazluzropa.models.Cliente;
import controllers.modazluzropa.services.ClienteService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {
    private ClienteService clienteService;

    @GetMapping("/all")
    public List<Cliente> getClientes(){
        return clienteService.getAll();
    }

    @GetMapping
    public Cliente getById(@RequestParam Integer id){
        return clienteService.getById(id);
    }

    @PostMapping
    public Cliente guardar(@RequestBody ClienteDTO cliente){
        return clienteService.guardar(cliente);
    }

   // @DeleteMapping("/{id}")
 //   public String eliminar(@PathVariable Integer id) {
    //    return clienteService.eliminar(id);
  //  }
}
