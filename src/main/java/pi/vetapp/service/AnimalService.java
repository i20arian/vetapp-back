package pi.vetapp.service;

import pi.vetapp.entity.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalService {
  List<Animal> getAll();

  Animal create(Animal animal);

  Optional<Animal> update(Animal animal);

  Optional<Animal> updateNombre(Long id, String nombre);

  Optional<Animal> updateTipo(Long id, String tipo);

  Optional<Animal> updateGenero(Long id, String genero);

  Optional<Animal> updateEdad(Long id, Integer edad);

  Optional<Animal> updatePeso(Long id, Double peso);

  Optional<Animal> updateRaza(Long id, String raza);

  Optional<Animal> updateColor(Long id, String color);

  boolean delete(Long id);
}