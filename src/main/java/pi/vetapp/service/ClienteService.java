package pi.vetapp.service;

import pi.vetapp.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
  List<Cliente> getAll();

  Cliente create(Cliente cliente);

  Optional<Cliente> update(Cliente cliente);

  Optional<Cliente> updateNombres(Long id, String nombres);

  Optional<Cliente> updateApellidos(Long id, String apellidos);

  Optional<Cliente> updateDni(Long id, String dni);

  Optional<Cliente> updateGenero(Long id, String genero);

  Optional<Cliente> updateCorreo(Long id, String correo);

  Optional<Cliente> updateCelular(Long id, String celular);

  Optional<Cliente> updateDireccion(Long id, String direccion);

  boolean delete(Long id);
}
