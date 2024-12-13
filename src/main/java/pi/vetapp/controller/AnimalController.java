package pi.vetapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.vetapp.entity.Animal;
import pi.vetapp.service.AnimalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animales")
public class AnimalController {
  private final AnimalService animalService;

  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @GetMapping("/listar")
  public ResponseEntity<List<Animal>> getAllAni() {
    List<Animal> animales = animalService.getAll();
    return animales.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
        : new ResponseEntity<>(animales, HttpStatus.OK);
  }

  @PostMapping("/insertar")
  public ResponseEntity<Animal> createAni(@RequestBody Animal animal) {
    Animal nuevoAnimal = animalService.create(animal);
    return new ResponseEntity<>(nuevoAnimal, HttpStatus.CREATED);
  }

  @PutMapping("/actualizar")
  public ResponseEntity<Animal> updateAni(@RequestBody Animal animal) {
    Optional<Animal> updatedAnimal = animalService.update(animal);
    if (updatedAnimal.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedAnimal.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-nombre/{id}")
  public ResponseEntity<Animal> updateNombreAni(@PathVariable("id") Long id, @RequestBody String nombre) {
    Optional<Animal> updatedAnimal = animalService.updateNombre(id, nombre);
    if (updatedAnimal.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedAnimal.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-tipo/{id}")
  public ResponseEntity<Animal> updateTipoAni(@PathVariable("id") Long id, @RequestBody String tipo) {
    Optional<Animal> updatedAnimal = animalService.updateTipo(id, tipo);
    if (updatedAnimal.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedAnimal.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-genero/{id}")
  public ResponseEntity<Animal> updateGeneroAni(@PathVariable("id") Long id, @RequestBody String genero) {
    Optional<Animal> updatedAnimal = animalService.updateGenero(id, genero);
    if (updatedAnimal.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedAnimal.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-edad/{id}")
  public ResponseEntity<Animal> updateEdadAni(@PathVariable("id") Long id, @RequestBody Integer edad) {
    Optional<Animal> updatedAnimal = animalService.updateEdad(id, edad);
    if (updatedAnimal.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedAnimal.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-peso/{id}")
  public ResponseEntity<Animal> updatePesoAni(@PathVariable("id") Long id, @RequestBody Double peso) {
    Optional<Animal> updatedAnimal = animalService.updatePeso(id, peso);
    if (updatedAnimal.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedAnimal.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-raza/{id}")
  public ResponseEntity<Animal> updateRazaAni(@PathVariable("id") Long id, @RequestBody String raza) {
    Optional<Animal> updatedAnimal = animalService.updateRaza(id, raza);
    if (updatedAnimal.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedAnimal.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-color/{id}")
  public ResponseEntity<Animal> updateColorAni(@PathVariable("id") Long id, @RequestBody String color) {
    Optional<Animal> updatedAnimal = animalService.updateColor(id, color);
    if (updatedAnimal.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedAnimal.get(), HttpStatus.OK);
  }

  @GetMapping("/encontrar/{id}")
  public ResponseEntity<Animal> findByIDAni(@PathVariable("id") Long id) {
    Optional<Animal> optAni = animalService.findByID(id);
    if (optAni.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(optAni.get(), HttpStatus.OK);
  }

  @DeleteMapping("/eliminar/{id}")
  public ResponseEntity<Void> deleteAni(@PathVariable("id") Long id) {
    boolean isDeleted = animalService.delete(id);
    if (!isDeleted) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
