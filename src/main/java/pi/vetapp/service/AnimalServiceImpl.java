package pi.vetapp.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pi.vetapp.entity.Animal;
import pi.vetapp.repository.AnimalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {
  private final AnimalRepository animalesRepository;

  @PersistenceContext
  private EntityManager entityManager;

  public AnimalServiceImpl(AnimalRepository animalesRepository) {
    this.animalesRepository = animalesRepository;
  }

  @Override
  public List<Animal> getAllAnimales() {
    // Obtiene todos los animales desde la base de datos
    return animalesRepository.findAll();
  }

  @Override
  public Animal insertarAnimal(Animal animal) {
    // Inserta un nuevo animal o actualiza uno existente si ya tiene un código
    return animalesRepository.save(animal);
  }

  @Override
  @Transactional
  public Animal actualizarAnimal(Long id, Animal animal) {
    Optional<Animal> existingAnimal = animalesRepository.findById(id);
    if (existingAnimal.isPresent()) {
      Animal animalToUpdate = existingAnimal.get();
      // Verificar si la información es la misma o si hubo cambios concurrentes
      if (animalToUpdate.getCodigoAnimal().equals(animal.getCodigoAnimal())) {
        animalToUpdate.setNombreAnimal(animal.getNombreAnimal());
        animalToUpdate.setDueno(animal.getDueno());
        animalToUpdate.setEdad(animal.getEdad());
        animalToUpdate.setPeso(animal.getPeso());
        animalToUpdate.setInformacionAnimal(animal.getInformacionAnimal());
        animalToUpdate.setGeneroAnim(animal.getGeneroAnim());
        animalToUpdate.setTipoAnimal(animal.getTipoAnimal());
        return animalesRepository.save(animalToUpdate);
      } else {
        throw new RuntimeException("Animal ha sido modificado por otra transacción");
      }
    } else {
      throw new RuntimeException("Animal no encontrado con ID: " + id);
    }
  }

  @Transactional
  @Override
  public void eliminarAnimal(Long id) {
    Optional<Animal> existingAnimal = animalesRepository.findById(id);
    if (existingAnimal.isPresent()) {
      // Verificar si el animal no fue eliminado en una transacción previa
      animalesRepository.deleteById(id);
    } else {
      throw new RuntimeException("Animal no encontrado con ID: " + id);
    }
  }
}
