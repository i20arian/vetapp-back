package pi.vetapp.service;

import pi.vetapp.entity.Cliente;

import java.util.List;

public interface ClienteService {
  List<Cliente> getAllClientes();

  Cliente insertarCliente(Cliente cliente);

  Cliente actualizarCliente(Long codigoCliente, Cliente cliente);

  void eliminarCliente(Long codigoCliente);
}
