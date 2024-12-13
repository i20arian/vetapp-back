package proyecto.integrador.Veterinaria.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import proyecto.integrador.Veterinaria.entity.Animales;
import proyecto.integrador.Veterinaria.repository.AnimalesRepository;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalesServiceImpl implements AnimalesService {
  private final AnimalesRepository animalesRepository;

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  public AnimalesServiceImpl(AnimalesRepository animalesRepository) {
    this.animalesRepository = animalesRepository;
  }

  @Override
  public List<Animales> getAllAnimales() {
    // Obtiene todos los animales desde la base de datos
    return animalesRepository.findAll();
  }

  @Override
  public Animales insertarAnimal(Animales animal) {
    // Inserta un nuevo animal o actualiza uno existente si ya tiene un código
    return animalesRepository.save(animal);
  }

  @Override
  @Transactional
  public Animales actualizarAnimal(Long id, Animales animal) {
    Optional<Animales> existingAnimal = animalesRepository.findById(id);
    if (existingAnimal.isPresent()) {
      Animales animalToUpdate = existingAnimal.get();
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
    Optional<Animales> existingAnimal = animalesRepository.findById(id);
    if (existingAnimal.isPresent()) {
      // Verificar si el animal no fue eliminado en una transacción previa
      animalesRepository.deleteById(id);
    } else {
      throw new RuntimeException("Animal no encontrado con ID: " + id);
    }
  }
}
