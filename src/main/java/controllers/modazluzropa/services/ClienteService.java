package controllers.modazluzropa.services;


import controllers.modazluzropa.dtos.ClienteDTO;
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
     * @param id
     */
    public String eliminar(Integer id) {
        try {
            clienteRepository.deleteById(id);
            return "Cliente eliminado";
        } catch (Exception e){
            return "No se ha podido eliminar el cliente";
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
