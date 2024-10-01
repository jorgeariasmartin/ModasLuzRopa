package controllers.modazluzropa.services;

import controllers.modazluzropa.models.Talla;
import controllers.modazluzropa.repositories.TallaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TallaService {

    private TallaRepository tallarepository;

    /**
     * Devuelve todas las tallas.
     * @return
     */
    public List<Talla> getAll(){
        return tallarepository.findAll();
    }

    /**
     * Devuelve una talla por ID.
     * @param id
     * @return
     */
    public Talla getById(Integer id) {
        return tallarepository.findById(id).orElse(null);
    }

    /**
     * Crea o edita una talla.
     * @param talla
     * @return
     */
    public Talla guardar(Talla talla) {
        return tallarepository.save(talla);
    }

    /**
     * Elimina una talla por ID.
     * @param id
     */
    public void eliminar(Integer id){
        tallarepository.deleteById(id);
    }

    /**
     * Elimina una talla.
     * @param talla
     */
    public void eliminar(Talla talla) {
        tallarepository.delete(talla);
    }
}
