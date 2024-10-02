package controllers.modazluzropa.services;

import controllers.modazluzropa.models.TallaProductoPrecio;
import controllers.modazluzropa.repositories.TallaProductoPrecioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TallaProductoPrecioService {

    private TallaProductoPrecioRepository tallaProductoPrecioRepository;

    /**
     * Devuelve todos los productos.
     * @return
     */
    public List<TallaProductoPrecio> getAll(){
        return tallaProductoPrecioRepository.findAll();
    }

    /**
     * Devuelve un producto por ID.
     * @param id
     * @return
     */
    public TallaProductoPrecio getById(Integer id) {
        return tallaProductoPrecioRepository.findById(id).orElse(null);
    }

    /**
     * Crea o edita un producto.
     * @param tallaProductoPrecio
     * @return
     */
    public TallaProductoPrecio guardar(TallaProductoPrecio tallaProductoPrecio) {
        return tallaProductoPrecioRepository.save(tallaProductoPrecio);
    }

    /**
     * Elimina un producto por ID.
     * @param id
     */
    public void eliminar(Integer id){
        tallaProductoPrecioRepository.deleteById(id);
    }

    /**
     * Elimina un producto.
     * @param tallaProductoPrecio
     */
    public void eliminar(TallaProductoPrecio tallaProductoPrecio){
        tallaProductoPrecioRepository.delete(tallaProductoPrecio);
    }

}
