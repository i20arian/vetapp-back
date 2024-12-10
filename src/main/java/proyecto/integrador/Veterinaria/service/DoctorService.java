package proyecto.integrador.Veterinaria.service;

import proyecto.integrador.Veterinaria.entity.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctores();

    Doctor insertarDoctor(Doctor doctor);

    Doctor actualizarDoctor(Integer codigoDoctor, Doctor doctor);

    void eliminarDoctor(Integer codigoDoctor);

}
