package pi.vetapp.service;

import org.springframework.stereotype.Service;
import pi.vetapp.entity.Animal;
import pi.vetapp.repository.AnimalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {
  private final AnimalRepository animalesRepository;

  public AnimalServiceImpl(AnimalRepository animalesRepository) {
    this.animalesRepository = animalesRepository;
  }

  @Override
  public List<Animal> getAll() {
    return animalesRepository.findAll();
  }

  @Override
  public Animal create(Animal animal) {
    return animalesRepository.save(animal);
  }

  @Override
  public Optional<Animal> update(Animal animal) {
    if (animal == null || animal.getId() == null) {
      return Optional.empty();
    }

    return Optional.of(animalesRepository.save(animal));
  }

  @Override
  public Optional<Animal> updateNombre(Long id, String nombre) {
    if (id == null || nombre == null) {
      return Optional.empty();
    }

    Optional<Animal> optAnimal = animalesRepository.findById(id);
    if (optAnimal.isEmpty()) {
      return Optional.empty();
    }

    Animal animal = optAnimal.get();
    animal.setNombre(nombre);
    return Optional.of(animalesRepository.save(animal));
  }

  @Override
  public Optional<Animal> updateTipo(Long id, String tipo) {
    if (id == null || tipo == null) {
      return Optional.empty();
    }

    Optional<Animal> optAnimal = animalesRepository.findById(id);
    if (optAnimal.isEmpty()) {
      return Optional.empty();
    }

    Animal animal = optAnimal.get();
    animal.setTipo(tipo);
    return Optional.of(animalesRepository.save(animal));
  }

  @Override
  public Optional<Animal> updateGenero(Long id, String genero) {
    if (id == null || genero == null) {
      return Optional.empty();
    }

    Optional<Animal> optAnimal = animalesRepository.findById(id);
    if (optAnimal.isEmpty()) {
      return Optional.empty();
    }

    Animal animal = optAnimal.get();
    animal.setGenero(genero);
    return Optional.of(animalesRepository.save(animal));
  }

  @Override
  public Optional<Animal> updateEdad(Long id, Integer edad) {
    if (id == null || edad == null) {
      return Optional.empty();
    }

    Optional<Animal> optAnimal = animalesRepository.findById(id);
    if (optAnimal.isEmpty()) {
      return Optional.empty();
    }

    Animal animal = optAnimal.get();
    animal.setEdad(edad);
    return Optional.of(animalesRepository.save(animal));
  }

  @Override
  public Optional<Animal> updatePeso(Long id, Double peso) {
    if (id == null || peso == null) {
      return Optional.empty();
    }

    Optional<Animal> optAnimal = animalesRepository.findById(id);
    if (optAnimal.isEmpty()) {
      return Optional.empty();
    }

    Animal animal = optAnimal.get();
    animal.setPeso(peso);
    return Optional.of(animalesRepository.save(animal));
  }

  @Override
  public Optional<Animal> updateRaza(Long id, String raza) {
    if (id == null || raza == null) {
      return Optional.empty();
    }

    Optional<Animal> optAnimal = animalesRepository.findById(id);
    if (optAnimal.isEmpty()) {
      return Optional.empty();
    }

    Animal animal = optAnimal.get();
    animal.setRaza(raza);
    return Optional.of(animalesRepository.save(animal));
  }

  @Override
  public Optional<Animal> updateColor(Long id, String color) {
    if (id == null || color == null) {
      return Optional.empty();
    }

    Optional<Animal> optAnimal = animalesRepository.findById(id);
    if (optAnimal.isEmpty()) {
      return Optional.empty();
    }

    Animal animal = optAnimal.get();
    animal.setColor(color);
    return Optional.of(animalesRepository.save(animal));
  }

  @Override
  public Optional<Animal> findByID(Long id) {
    if (id == null) {
      return Optional.empty();
    }

    return animalesRepository.findById(id);
  }

  @Override
  public boolean delete(Long id) {
    if (!animalesRepository.existsById(id)) {
      return false;
    }

    animalesRepository.deleteById(id);
    return true;
  }
}
