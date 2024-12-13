package pi.vetapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pi.vetapp.entity.Animal;
import pi.vetapp.entity.Cliente;
import pi.vetapp.entity.HistoriaClinica;
import pi.vetapp.entity.Medico;
import pi.vetapp.service.HistoriaClinicaService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historias-clinicas")
public class HistoriaClinicaController {
  private final HistoriaClinicaService historiaClinicaService;

  public HistoriaClinicaController(HistoriaClinicaService historiaClinicaService) {
    this.historiaClinicaService = historiaClinicaService;
  }

  @GetMapping("/listar")
  public ResponseEntity<List<HistoriaClinica>> getAllHC() {
    List<HistoriaClinica> historiasClinicas = historiaClinicaService.getAll();
    return historiasClinicas.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
        : new ResponseEntity<>(historiasClinicas, HttpStatus.OK);
  }

  @PostMapping("/insertar")
  public ResponseEntity<HistoriaClinica> createHC(@RequestBody HistoriaClinica historiaClinica) {
    HistoriaClinica nuevaHistoriaClinica = historiaClinicaService.create(historiaClinica);
    return new ResponseEntity<>(nuevaHistoriaClinica, HttpStatus.CREATED);
  }

  @PutMapping("/actualizar")
  public ResponseEntity<HistoriaClinica> updateHC(@RequestBody HistoriaClinica historiaClinica) {
    Optional<HistoriaClinica> updatedHistoriaClinica = historiaClinicaService.update(historiaClinica);
    if (updatedHistoriaClinica.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedHistoriaClinica.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-fecha-registro/{id}")
  public ResponseEntity<HistoriaClinica> updateFechaRegistroHC(@PathVariable("id") Long id,
      @RequestBody LocalDate fechaDeRegistro) {
    Optional<HistoriaClinica> updatedHistoriaClinica = historiaClinicaService.updateFechaDeRegistro(id,
        fechaDeRegistro);
    if (updatedHistoriaClinica.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedHistoriaClinica.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-hora-registro/{id}")
  public ResponseEntity<HistoriaClinica> updateHoraRegistroHC(@PathVariable("id") Long id,
      @RequestBody LocalTime horaDeRegistro) {
    Optional<HistoriaClinica> updatedHistoriaClinica = historiaClinicaService.updateHoraDeRegistro(id, horaDeRegistro);
    if (updatedHistoriaClinica.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedHistoriaClinica.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-animal/{id}")
  public ResponseEntity<HistoriaClinica> updateAnimalHC(@PathVariable("id") Long id, @RequestBody Animal animal) {
    Optional<HistoriaClinica> updatedHistoriaClinica = historiaClinicaService.updateAnimal(id, animal);
    if (updatedHistoriaClinica.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedHistoriaClinica.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-cliente/{id}")
  public ResponseEntity<HistoriaClinica> updateClienteHC(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
    Optional<HistoriaClinica> updatedHistoriaClinica = historiaClinicaService.updateCliente(id, cliente);
    if (updatedHistoriaClinica.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedHistoriaClinica.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-medico/{id}")
  public ResponseEntity<HistoriaClinica> updateMedicoHC(@PathVariable("id") Long id, @RequestBody Medico medico) {
    Optional<HistoriaClinica> updatedHistoriaClinica = historiaClinicaService.updateMedico(id, medico);
    if (updatedHistoriaClinica.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(updatedHistoriaClinica.get(), HttpStatus.OK);
  }

  @DeleteMapping("/eliminar/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    boolean isDeleted = historiaClinicaService.delete(id);
    if (!isDeleted) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
