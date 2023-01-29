package bienestar.api_fichapaciente.fichapaciente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/fichapaciente")

@CrossOrigin({"*"})
public class FichapacienteController {
 @Autowired FichapacienteService fichapacienteService;
 @GetMapping("/")
 public List<Fichapaciente> findAll(){
 return fichapacienteService.findAll();
 }
 @GetMapping("/{id}/")
 public Fichapaciente findById(@PathVariable Long id){
 return fichapacienteService.findById(id);
 }
 @PostMapping("/")
 public Fichapaciente save(@RequestBody Fichapaciente entity){
 return fichapacienteService.save(entity);
 }
 @PutMapping("/")
 public Fichapaciente update(@RequestBody Fichapaciente entity){
 return fichapacienteService.save(entity);
 }
 @DeleteMapping("/{id}/")
 public void deleteById(@PathVariable Long id){
    fichapacienteService.deleteById(id);
 }
}