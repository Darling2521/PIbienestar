package bienestar.api_fichapaciente.fichapaciente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FichapacienteService {
 @Autowired FichapacienteRepository fichapacienteRepository;
 public Fichapaciente save(Fichapaciente entity){
 return fichapacienteRepository.save(entity);
 }
 public Fichapaciente findById( Long id){
 return fichapacienteRepository.findById(id).orElse(new Fichapaciente());
 }
 public void deleteById(Long id){
    fichapacienteRepository.deleteById(id);
 }
 public List<Fichapaciente> findAll(){
 return fichapacienteRepository.findAll();
 }
}