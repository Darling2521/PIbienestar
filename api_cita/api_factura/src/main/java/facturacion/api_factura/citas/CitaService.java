package facturacion.api_factura.citas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class CitaService {
    @Autowired CitaRepository entityRepository;

    public Cita save(Cita entity){
        return entityRepository.save(entity);
    }

    public Cita findById( Long id){
        return entityRepository.findById(id).orElse(new Cita());
    }

    public void deleteById(Long id){
        entityRepository.deleteById(id);
    }

    public List<Cita> findAll(){
        return entityRepository.findAll();
    }
}
