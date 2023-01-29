package citas.api_cita.cita;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    public List<Cita>findAll();    
}
