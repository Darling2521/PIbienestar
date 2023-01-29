package facturacion.api_factura.citas;

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
@RequestMapping("api/cita")
@CrossOrigin({"*"})
public class CitaController {
    @Autowired CitaService citaService;

    @GetMapping("/")
    public List<Cita> findAll(){
        return citaService.findAll();
    }

    @GetMapping("/{id}/")
    public Cita findById(@PathVariable Long id){
        return citaService.findById(id);
    }

    @PostMapping("/")
    public Cita save(@RequestBody Cita entity){
        return citaService.save(entity);
    }

    @PutMapping("/{id}/")
    public Cita update(@RequestBody Cita entity){
        return citaService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        citaService.deleteById(id);
    }

}
