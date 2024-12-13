package proyecto.integrador.Veterinaria.service;

import proyecto.integrador.Veterinaria.entity.Animal;

import java.util.List;

public interface AnimalService {
  // Obtener todos los animales
  List<Animal> getAllAnimales();

  // Insertar un nuevo animal
  Animal insertarAnimal(Animal animal);

  // Actualizar un animal
  Animal actualizarAnimal(Long id, Animal animal);

  // Eliminar un animal
  void eliminarAnimal(Long id);
}
