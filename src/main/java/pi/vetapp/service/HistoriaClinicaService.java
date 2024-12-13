package pi.vetapp.service;

import pi.vetapp.entity.Animal;
import pi.vetapp.entity.Cliente;
import pi.vetapp.entity.HistoriaClinica;
import pi.vetapp.entity.Medico;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface HistoriaClinicaService {
  List<HistoriaClinica> getAll();

  HistoriaClinica create(HistoriaClinica historiaClinica);

  Optional<HistoriaClinica> update(HistoriaClinica historiaClinica);

  Optional<HistoriaClinica> updateFechaDeRegistro(Long id, LocalDate fechaDeRegistro);

  Optional<HistoriaClinica> updateHoraDeRegistro(Long id, LocalTime horaDeRegistro);

  Optional<HistoriaClinica> updateAnimal(Long id, Animal animal);

  Optional<HistoriaClinica> updateCliente(Long id, Cliente cliente);

  Optional<HistoriaClinica> updateMedico(Long id, Medico medico);

  boolean delete(Long id);
}
