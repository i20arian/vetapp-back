package proyecto.integrador.Veterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.integrador.Veterinaria.entity.Cliente;
import proyecto.integrador.Veterinaria.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
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
            clienteToUpdate.setNombreCliente(cliente.getNombreCliente());
            clienteToUpdate.setApellidosCliente(cliente.getApellidosCliente());
            clienteToUpdate.setDniCliente(cliente.getDniCliente());
            clienteToUpdate.setInformacionCliente(cliente.getInformacionCliente());
            clienteToUpdate.setGeneroClie(cliente.getGeneroClie());
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
