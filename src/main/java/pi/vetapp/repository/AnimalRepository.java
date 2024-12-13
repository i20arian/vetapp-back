package pi.vetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.vetapp.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
