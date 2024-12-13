package pi.vetapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.vetapp.entity.Animal;
import pi.vetapp.service.AnimalService;

import java.util.List;

@RestController
@RequestMapping("/api/animales")
public class AnimalController {
  private final AnimalService animalesService;

  public AnimalController(AnimalService animalesService) {
    this.animalesService = animalesService;
  }

  // Ruta para obtener todos los animales
  @GetMapping("/listar")
  public ResponseEntity<List<Animal>> getAllAnimales() {
    List<Animal> animales = animalesService.getAllAnimales();
    return animales.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
        : new ResponseEntity<>(animales, HttpStatus.OK);
  }

  // Ruta para insertar un nuevo animal
  @PostMapping("/insertar")
  public ResponseEntity<Animal> insertarAnimal(@RequestBody Animal animal) {
    Animal savedAnimal = animalesService.insertarAnimal(animal);
    return new ResponseEntity<>(savedAnimal, HttpStatus.CREATED);
  }

  // Ruta para actualizar un animal
  @PutMapping("/actualizar/{id}")
  public ResponseEntity<Animal> actualizarAnimal(@PathVariable("id") Long id, @RequestBody Animal animal) {
    Animal updatedAnimal = animalesService.actualizarAnimal(id, animal);
    if (updatedAnimal != null) {
      return new ResponseEntity<>(updatedAnimal, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Animal no encontrado
  }

  @DeleteMapping("/eliminar/{id}")
  public ResponseEntity<Void> eliminarAnimal(@PathVariable("id") Long id) {
    try {
      animalesService.eliminarAnimal(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Eliminado con éxito
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Animal no encontrado
    }
  }
}
