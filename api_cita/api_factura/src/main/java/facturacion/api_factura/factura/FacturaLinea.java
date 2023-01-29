package facturacion.api_factura.factura;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import facturacion.api_factura.citas.Cita;


@Data
@Entity
public class FacturaLinea {

    @Id
    //El generate nos ayuda a que automaticamente JA sepa que tiene una primery Ki
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //relaciones que nos ayuda o permite en este caso una relacion o referenciaa otra entidad
    //una linia de cita va a estar un cita asociada que va a tener una Obsevacion
    private Cita cita;
    private String observacion;


    
}
