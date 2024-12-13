package pi.vetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pi.vetapp.entity.HistoriaClinica;

public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {
}
