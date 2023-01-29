package facturacion.api_factura.factura;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends CrudRepository<Factura, Long>{

    List<Factura>findAll();
    
}
