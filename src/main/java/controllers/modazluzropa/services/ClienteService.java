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

    /**
     * De
     * @param nombre
     * @return
     */
    public List<Cliente> findClientebyNombre(String nombre) {
        return clienteRepository.findClienteByNombre(nombre);
    }

    /**
     * Devuelve todas las empresas.
     * @return
     */
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    /**
     * Devuelve el cliente con ese ID.
     * @param id
     * @return
     */
    public Cliente getById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
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

    /**
     * Elimina un cliente.
     * @param cliente
     */
    public void eliminar(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
