package controllers.modazluzropa.services;


import controllers.modazluzropa.dtos.ClienteDTO;
import controllers.modazluzropa.models.Cliente;
import controllers.modazluzropa.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
     * @param dto
     * @return
     */

    public Cliente guardar(ClienteDTO dto) {
        Cliente clienteGuardar = new Cliente();
        clienteGuardar.setNombre(dto.getNombre());
        clienteGuardar.setApellidos(dto.getApellidos());
        clienteGuardar.setDni(dto.getDni());

        return clienteRepository.save(clienteGuardar);
    }


    /**
     * Elimina un cliente por ID.
     *
     * @param id ID del cliente.
     * @throws NoSuchElementException si el cliente no existe.
     */
    public void eliminar(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Cliente con ID " + id + " no encontrado");
        }
    }

    /**
     * Elimina un cliente.
     * @param cliente
     */
    public void eliminar(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
