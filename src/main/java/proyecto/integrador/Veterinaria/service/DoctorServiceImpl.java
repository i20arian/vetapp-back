package proyecto.integrador.Veterinaria.service;

import org.springframework.stereotype.Service;
import proyecto.integrador.Veterinaria.entity.Doctor;
import proyecto.integrador.Veterinaria.repository.DoctorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
  private final DoctorRepository doctorRepository;

  public DoctorServiceImpl(DoctorRepository doctorRepository) {
    this.doctorRepository = doctorRepository;
  }

  @Override
  public List<Doctor> getAllDoctores() {
    return doctorRepository.findAll();
  }

  @Override
  public Doctor insertarDoctor(Doctor doctor) {
    return doctorRepository.save(doctor);
  }

  @Override
  public Doctor actualizarDoctor(Integer codigoDoctor, Doctor doctor) {
    Optional<Doctor> existingDoctor = doctorRepository.findById(codigoDoctor);
    if (existingDoctor.isPresent()) {
      Doctor doctorToUpdate = existingDoctor.get();
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
