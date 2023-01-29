package facturacion.api_factura.factura;

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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;




@RestController
@RequestMapping("api/factura")
@CrossOrigin({"*"})

public class FacturaController {
    @Autowired FacturaService facturaService;

    @GetMapping("/")
    public List<Factura> findAll(){
        return facturaService.findAll();
    }

    @GetMapping("/{id}/")
    public Factura findById(@PathVariable Long id){
        return facturaService.findById(id);
    }

    @PostMapping("/")
    public Factura save(@RequestBody Factura entity){
        return facturaService.save(entity);
    }

    @PutMapping("/{id}/")
    public Factura update(@RequestBody Factura entity){
        return facturaService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        facturaService.deleteById(id);
    }  

    //metodo que se le pide que genere el reporte
    //aqui se ocupara el servicio que se le midifico 
    //el metodo getFactura reporte que resive el id de la factura que deseamos
    //crear y eso nos entregara un jasperpring
    //y va agenerar una respuesta rest en este caso es en responseentity
    //de tipo byt para entregar el reporte en pdf y le indicarmemos como se llame 
    //el archivo que va a esatr entregando
    @GetMapping("/pdf/{id}/")//url que va a estar escuchando
	public ResponseEntity<byte[]> getFacturaReporte(@PathVariable long id) throws JRException {

		JasperPrint reporte = facturaService.getFacturaReporte(id);
        
        if (reporte==null)//en el caso de que este igual nos indicara un null
            return new ResponseEntity<byte[]>(null, null, HttpStatus.NOT_FOUND);
        //en caso contrario creera un herader para decir que tipo de contenido es pdf 
        //y como se llamara el nombre del archivo
		HttpHeaders headers = new HttpHeaders();
		// set the PDF format
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("filename", "factura.pdf");
		// create the report in PDF format
		return new ResponseEntity<byte[]>//entrega con un return un tipo responentity en el atraves
        //de una libreria del mismo jasper que va a convertir el mismo jasper a pdf se puede crear varios formatos 
        //se le pasa los header que se crea arriba y se le dice con una respuesta ok 
(JasperExportManager.exportReportToPdf(reporte), headers, HttpStatus.OK);

	}



}
