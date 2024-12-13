package pi.vetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.vetapp.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
