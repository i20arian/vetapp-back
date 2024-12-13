package proyecto.integrador.Veterinaria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.integrador.Veterinaria.entity.Cliente;
import proyecto.integrador.Veterinaria.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
  private final ClienteService clienteService;

  public ClienteController(ClienteService clienteService) {
    this.clienteService = clienteService;
  }

  @GetMapping("/listar")
  public ResponseEntity<List<Cliente>> getAllClientes() {
    List<Cliente> clientes = clienteService.getAllClientes();
    return clientes.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
        : new ResponseEntity<>(clientes, HttpStatus.OK);
  }

  @PostMapping("/insertar")
  public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente cliente) {
    Cliente nuevoCliente = clienteService.insertarCliente(cliente);
    return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
  }

  @PutMapping("/actualizar/{id}")
  public ResponseEntity<Cliente> actualizarCliente(@PathVariable("id") int id, @RequestBody Cliente cliente) {
    try {
      Cliente clienteActualizado = clienteService.actualizarCliente(id, cliente);
      return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/eliminar/{id}")
  public ResponseEntity<Void> eliminarCliente(@PathVariable("id") int id) {
    try {
      clienteService.eliminarCliente(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (RuntimeException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
