package facturacion.api_factura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class ApiFacturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFacturaApplication.class, args);
	}

}
