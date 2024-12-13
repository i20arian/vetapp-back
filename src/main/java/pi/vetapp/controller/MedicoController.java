package pi.vetapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.vetapp.entity.Medico;
import pi.vetapp.service.MedicoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {
  private final MedicoService medicoService;

  public MedicoController(MedicoService medicoService) {
    this.medicoService = medicoService;
  }

  @GetMapping("/listar")
  public ResponseEntity<List<Medico>> getAllMed() {
    List<Medico> medicos = medicoService.getAll();
    return medicos.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
        : new ResponseEntity<>(medicos, HttpStatus.OK);
  }

  @PostMapping("/insertar")
  public ResponseEntity<Medico> createMed(@RequestBody Medico medico) {
    Medico nuevoMedico = medicoService.create(medico);
    return new ResponseEntity<>(nuevoMedico, HttpStatus.CREATED);
  }

  @PutMapping("/actualizar")
  public ResponseEntity<Medico> updateMed(@RequestBody Medico medico) {
    Optional<Medico> updatedMedico = medicoService.update(medico);
    if (updatedMedico.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedMedico.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-nombres/{id}")
  public ResponseEntity<Medico> updateNombresMed(@PathVariable("id") Long id, @RequestBody String nombres) {
    Optional<Medico> updatedMedico = medicoService.updateNombres(id, nombres);
    if (updatedMedico.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedMedico.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-apellidos/{id}")
  public ResponseEntity<Medico> updateApellidosMed(@PathVariable("id") Long id, @RequestBody String apellidos) {
    Optional<Medico> updatedMedico = medicoService.updateApellidos(id, apellidos);
    if (updatedMedico.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedMedico.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-especialidad/{id}")
  public ResponseEntity<Medico> updateEspecialidadMed(@PathVariable("id") Long id,
      @RequestBody String especialidad) {
    Optional<Medico> updatedMedico = medicoService.updateEspecialidad(id, especialidad);
    if (updatedMedico.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedMedico.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-dni/{id}")
  public ResponseEntity<Medico> updateDniMed(@PathVariable("id") Long id, @RequestBody String dni) {
    Optional<Medico> updatedMedico = medicoService.updateDni(id, dni);
    if (updatedMedico.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedMedico.get(), HttpStatus.OK);
  }

  @DeleteMapping("/eliminar/{id}")
  public ResponseEntity<Void> deleteMed(@PathVariable("id") Long id) {
    boolean isDeleted = medicoService.delete(id);
    if (!isDeleted) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
