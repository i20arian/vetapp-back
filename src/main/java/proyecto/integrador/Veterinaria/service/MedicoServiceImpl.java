package proyecto.integrador.Veterinaria.service;

import org.springframework.stereotype.Service;
import proyecto.integrador.Veterinaria.entity.Medico;
import proyecto.integrador.Veterinaria.repository.MedicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {
  private final MedicoRepository doctorRepository;

  public MedicoServiceImpl(MedicoRepository doctorRepository) {
    this.doctorRepository = doctorRepository;
  }

  @Override
  public List<Medico> getAllDoctores() {
    return doctorRepository.findAll();
  }

  @Override
  public Medico insertarDoctor(Medico doctor) {
    return doctorRepository.save(doctor);
  }

  @Override
  public Medico actualizarDoctor(Integer codigoDoctor, Medico doctor) {
    Optional<Medico> existingDoctor = doctorRepository.findById(codigoDoctor);
    if (existingDoctor.isPresent()) {
      Medico doctorToUpdate = existingDoctor.get();
      doctorToUpdate.setNombreDoctor(doctor.getNombreDoctor());
      doctorToUpdate.setApellidoDoctor(doctor.getApellidoDoctor());
      doctorToUpdate.setDniDoctor(doctor.getDniDoctor());
      doctorToUpdate.setEspecialidad(doctor.getEspecialidad());
      doctorToUpdate.setExperiencia(doctor.getExperiencia());
      return doctorRepository.save(doctorToUpdate);
    } else {
      throw new RuntimeException("Doctor no encontrado con el ID: " + codigoDoctor);
    }
  }

  @Override
  public void eliminarDoctor(Integer codigoDoctor) {
    doctorRepository.deleteById(codigoDoctor);
  }
}
