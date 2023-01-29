package citas.api_cita.cita;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {
    @Autowired CitaRepository citaRepository;

    public Cita save(Cita entity){
        return citaRepository.save(entity);
    }

    public Cita findById(Long id){
        return citaRepository.findById(id).orElse(new Cita());
    }
    
    public void deleteById(Long id){
        citaRepository.deleteById(id);
    }

    public List<Cita> findAll(){
        return citaRepository.findAll();
    }
}
