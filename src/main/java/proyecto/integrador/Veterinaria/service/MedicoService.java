package proyecto.integrador.Veterinaria.service;

import proyecto.integrador.Veterinaria.entity.Medico;

import java.util.List;

public interface MedicoService {
  List<Medico> getAllDoctores();

  Medico insertarDoctor(Medico doctor);

  Medico actualizarDoctor(Integer codigoDoctor, Medico doctor);

  void eliminarDoctor(Integer codigoDoctor);
}
