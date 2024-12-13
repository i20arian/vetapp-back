package proyecto.integrador.Veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.integrador.Veterinaria.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
