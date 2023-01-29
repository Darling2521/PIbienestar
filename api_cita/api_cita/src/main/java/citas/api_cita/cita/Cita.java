package citas.api_cita.cita;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long citaid;
    private String nombre;
    private String apellido;
    private String curso;
    private String carrera;
    private String fecha;
    private String hora;
    private String nombreDoc;


    
}
