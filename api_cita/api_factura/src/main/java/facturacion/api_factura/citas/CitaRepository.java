package facturacion.api_factura.citas;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CitaRepository extends CrudRepository<Cita, Long> {

    public List<Cita>findAll();
    
}
