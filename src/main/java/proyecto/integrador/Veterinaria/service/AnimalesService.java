package proyecto.integrador.Veterinaria.service;

import proyecto.integrador.Veterinaria.entity.Animales;

import java.util.List;

public interface AnimalesService {

    // Obtener todos los animales
    List<Animales> getAllAnimales();

    // Insertar un nuevo animal
    Animales insertarAnimal(Animales animal);

    // Actualizar un animal
    Animales actualizarAnimal(Long id, Animales animal);

    // Eliminar un animal
    void eliminarAnimal(Long id);

}
