package facturacion.api_factura.cliente;

 import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String razon_social;
    private String nro_identificacion;
}


