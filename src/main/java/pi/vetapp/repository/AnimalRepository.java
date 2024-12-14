package pi.vetapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.vetapp.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
  List<Animal> findByNombreContainingIgnoreCase(String nombre);

  List<Animal> findByTipoContainingIgnoreCase(String tipo);

  List<Animal> findByGeneroContainingIgnoreCase(String genero);

  List<Animal> findByEdad(Integer edad);

  List<Animal> findByPeso(Double peso);

  List<Animal> findByRazaContainingIgnoreCase(String raza);

  List<Animal> findByColorContainingIgnoreCase(String color);

  List<Animal> findByCliente_Id(Long clienteId);
}
