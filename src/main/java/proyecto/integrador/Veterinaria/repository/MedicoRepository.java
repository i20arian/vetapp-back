package proyecto.integrador.Veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.integrador.Veterinaria.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
