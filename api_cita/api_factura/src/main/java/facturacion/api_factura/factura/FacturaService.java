package facturacion.api_factura.factura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.ResourceUtils;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import facturacion.api_factura.cliente.CustomerClient;
import facturacion.api_factura.cliente.CustomerDTO;


@Service
public class FacturaService {
    @Autowired FacturaRepository facturaRepository;
    @Autowired CustomerClient customerClient;


    public Factura save(Factura entity){
        return facturaRepository.save(entity);
    }

    public Factura findById( Long id){
        return facturaRepository.findById(id).orElse(new Factura());
    }

    public void deleteById(Long id){
        facturaRepository.deleteById(id);
    }

    public List<Factura> findAll(){
        return facturaRepository.findAll();
    }

    
    public JasperPrint getFacturaReporte(Long id) {

        ////esta es una lista de mapas de cable valor 
        Map<String, Object> reportParameters = new HashMap<String, Object>();
        Factura factura = findById(id);
        if (factura.getId()==null)
            return null;
        
        reportParameters.put("nro", factura.getNumeroFactura());
        reportParameters.put("fecha",Date.valueOf(factura.getFecha()));

        CustomerDTO cliente =  customerClient.findCustomerById(factura.getClienteId());
        reportParameters.put("nombre_cliente", cliente.getRazon_social());
        reportParameters.put("identificacion", cliente.getNro_identificacion());
        

        //esta es una lista de mapas de cable valor que seria equibalente a todas las lineas si en mi factiura es 
        //o tengo 5 citas que facture entonces esta lista es de tamaño 5
        //de las facturas extraemos las lineas
        //mediante un for recorremos linea por linea
        //y en un mapa temporal local de este metodo inyectaremos el resto de campos que se desea 
        //pasar al reporte 
        
        /*List<Map<String, Object>> dataList = new ArrayList<>();

        for (FacturaLinea linea : factura.getLineas()){
            Map<String, Object> data = new HashMap<>();
            data.put("nombreCita", linea.getCita().getNombre());
            data.put("observaciones",linea.getObservaciones());
           
        }*/
        //reportParameters.put("lineasFactura", new JRBeanCollectionDataSource(dataList));

        //esta seccion de codigo se hace utilizar las librerias de jasper donde se especufica
        //de donde se va a sacar el diseño que ya se realizo en este caso del resourseque classpath
        JasperPrint reportJasperPrint = null;
        try {
            reportJasperPrint = JasperFillManager.fillReport(
                    JasperCompileManager.compileReport(
                            ResourceUtils.getFile("classpath:jrxml/reporte.jrxml")
                                    .getAbsolutePath()) // path of the jasper report
                    , reportParameters // dynamic parameters
                    , new JREmptyDataSource());
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
        }
        return reportJasperPrint;
    }

}
