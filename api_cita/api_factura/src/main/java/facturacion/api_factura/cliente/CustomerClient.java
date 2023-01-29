package facturacion.api_factura.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//el rest client no se refiere a clientes si no a que va a traer informacion de otro microservicio
//el feigncliente es a nivel de res de post get put  y se asigna un nombre con quien mas o menos se va a esatr conectado
//se especifica en su parametro url a donde va a pedir informacion
//en este caso la api clientes si se creo en pyton y esta en el puerto 8000 y java va a pedir a pyton 
//la informacion  
@FeignClient(name = "bff.customer", url = "http://localhost:8000/api/cliente")
public interface CustomerClient {

    //este get mapping no es para especificar que esta interface va a estar escuchando este metodo get
    //no si no que va a pedir a este url a este cliente un get ose le va aser una peticion get
    //en el que va a pasar un parametro id a tra vez del metodo
    //CustomerDTO 
    //cual va aser el retorno de este metodo sera un customerDto le va a pedir 
    //a python un cliente a traaves del id 
    @GetMapping("/{id}/")
    CustomerDTO findCustomerById(@PathVariable("id") Long id);
}
