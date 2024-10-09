package controllers.modazluzropa.services;

import controllers.modazluzropa.dtos.TallaDTO;
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
     * @param dto
     * @return
     */
    public Talla guardar(TallaDTO dto) {
        Talla tallaGuardar = new Talla();
        tallaGuardar.setTalla(dto.getTipoTalla());
        tallaGuardar.setDescripcion(dto.getDescripcion());

        return tallarepository.save(tallaGuardar);
    }

    /**
     * Elimina una talla por ID.
     * @param id
     */
    public String eliminar(Integer id){
        try {
            tallarepository.deleteById(id);
            return "Talla eliminada";
        } catch (Exception e){
            return "No se ha podido eliminar la talla";
        }
    }

    /**
     * Elimina una talla.
     * @param talla
     */
    public void eliminar(Talla talla) {
        tallarepository.delete(talla);
    }
}
