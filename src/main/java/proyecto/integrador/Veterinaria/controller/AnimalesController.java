package proyecto.integrador.Veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.integrador.Veterinaria.entity.Animales;
import proyecto.integrador.Veterinaria.service.AnimalesService;

import java.util.List;

@RestController
@RequestMapping("/api/animales")
public class AnimalesController {

    private final AnimalesService animalesService;

    @Autowired
    public AnimalesController(AnimalesService animalesService) {
        this.animalesService = animalesService;
    }

    // Ruta para obtener todos los animales
    @GetMapping("/listar")
    public ResponseEntity<List<Animales>> getAllAnimales() {
        List<Animales> animales = animalesService.getAllAnimales();
        return animales.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(animales, HttpStatus.OK);
    }

    // Ruta para insertar un nuevo animal
    @PostMapping("/insertar")
    public ResponseEntity<Animales> insertarAnimal(@RequestBody Animales animal) {
        Animales savedAnimal = animalesService.insertarAnimal(animal);
        return new ResponseEntity<>(savedAnimal, HttpStatus.CREATED);
    }

    // Ruta para actualizar un animal
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Animales> actualizarAnimal(@PathVariable("id") Long id, @RequestBody Animales animal) {
        Animales updatedAnimal = animalesService.actualizarAnimal(id, animal);
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
