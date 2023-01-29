package bienestar.api_fichapaciente.fichapaciente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FichapacienteRepository extends JpaRepository<Fichapaciente, Long> {
 
    public List<Fichapaciente> findAll();

}