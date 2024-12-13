package pi.vetapp.service;

import org.springframework.stereotype.Service;
import pi.vetapp.entity.Cliente;
import pi.vetapp.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
  private final ClienteRepository clienteRepository;

  public ClienteServiceImpl(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  @Override
  public List<Cliente> getAllClientes() {
    return clienteRepository.findAll(); // Obtiene todos los clientes
  }

  @Override
  public Cliente insertarCliente(Cliente cliente) {
    return clienteRepository.save(cliente); // Inserta un nuevo cliente
  }

  @Override
  public Cliente actualizarCliente(int codigoCliente, Cliente cliente) {
    Optional<Cliente> existingCliente = clienteRepository.findById(codigoCliente);
    if (existingCliente.isPresent()) {
      Cliente clienteToUpdate = existingCliente.get();
      clienteToUpdate.setNombres(cliente.getNombres());
      clienteToUpdate.setApellidos(cliente.getApellidos());
      clienteToUpdate.setDni(cliente.getDni());
      clienteToUpdate.setGenero(cliente.getGenero());
      return clienteRepository.save(clienteToUpdate); // Guarda los cambios
    } else {
      throw new RuntimeException("Cliente no encontrado con ID: " + codigoCliente);
    }
  }

  @Override
  public void eliminarCliente(int codigoCliente) {
    if (clienteRepository.existsById(codigoCliente)) {
      clienteRepository.deleteById(codigoCliente); // Elimina el cliente
    } else {
      throw new RuntimeException("Cliente no encontrado con ID: " + codigoCliente);
    }
  }
}
