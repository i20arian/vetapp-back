package proyecto.integrador.Veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.integrador.Veterinaria.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
