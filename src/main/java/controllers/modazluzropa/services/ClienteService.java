package controllers.modazluzropa.services;


import controllers.modazluzropa.models.Cliente;
import controllers.modazluzropa.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;

    public List<Cliente> findClientebyNombre(String Nombre) {
        return null;
    }

    /**
     * Crea o edita una empresa.
     * @param c
     * @return
     */

    public Cliente guardar(Cliente c) {
        return clienteRepository.save(c);
    }


    /**
     * Elimina un cliente por id.
     * @param id
     */
    public void eliminar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
