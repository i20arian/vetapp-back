package proyecto.integrador.Veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.integrador.Veterinaria.entity.Animales;

@Repository
public interface AnimalesRepository extends JpaRepository<Animales, Long> {


}
