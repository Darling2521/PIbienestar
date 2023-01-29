import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Data //se crea los geteres y seteres
@Entity //
public class Factura{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroFactura;
    private LocalDate fecha;
    private Long clienteId;
   

//el onetomany nos permite indicar que muchas en lineas va a estar asociada a esta unica factura
//le tenemos que decir el tipo de cascado
//se coloca el ALL para todas las operaciones como actualizacion borrado o eliminacion 
// Y que lo huerfanos se borren automaticamente si se borra el encabezado de la factura
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//el joincolumn es para especificar el nombre de como se va a llamar la columna de enlace cuando se cree la tabla 
// de lineas 
    @JoinColumn(name = "factura_id")
    private List<FacturaLinea> lineas = new ArrayList<>()

}