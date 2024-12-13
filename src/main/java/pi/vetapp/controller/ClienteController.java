package pi.vetapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pi.vetapp.entity.Cliente;
import pi.vetapp.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
  private final ClienteService clienteService;

  public ClienteController(ClienteService clienteService) {
    this.clienteService = clienteService;
  }

  @GetMapping("/listar")
  public ResponseEntity<List<Cliente>> getAllCli() {
    List<Cliente> clientes = clienteService.getAll();
    return clientes.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
        : new ResponseEntity<>(clientes, HttpStatus.OK);
  }

  @PostMapping("/insertar")
  public ResponseEntity<Cliente> createCli(@RequestBody Cliente cliente) {
    Cliente nuevoCliente = clienteService.create(cliente);
    return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
  }

  @PutMapping("/actualizar")
  public ResponseEntity<Cliente> updateCli(@RequestBody Cliente cliente) {
    Optional<Cliente> optCli = clienteService.update(cliente);
    if (optCli.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(optCli.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-nombres/{id}")
  public ResponseEntity<Cliente> updateNombresCli(@PathVariable("id") Long id, @RequestBody String nombres) {
    Optional<Cliente> optCli = clienteService.updateNombres(id, nombres);
    if (optCli.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(optCli.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-apellidos/{id}")
  public ResponseEntity<Cliente> updateApellidosCli(@PathVariable("id") Long id, @RequestBody String apellidos) {
    Optional<Cliente> optCli = clienteService.updateApellidos(id, apellidos);
    if (optCli.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(optCli.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-dni/{id}")
  public ResponseEntity<Cliente> updateDniCli(@PathVariable("id") Long id, @RequestBody String dni) {
    Optional<Cliente> optCli = clienteService.updateDni(id, dni);
    if (optCli.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(optCli.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-genero/{id}")
  public ResponseEntity<Cliente> updateGeneroCli(@PathVariable("id") Long id, @RequestBody String genero) {
    Optional<Cliente> optCli = clienteService.updateGenero(id, genero);
    if (optCli.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(optCli.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-correo/{id}")
  public ResponseEntity<Cliente> updateCorreoCli(@PathVariable("id") Long id, @RequestBody String correo) {
    Optional<Cliente> optCli = clienteService.updateCorreo(id, correo);
    if (optCli.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(optCli.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-celular/{id}")
  public ResponseEntity<Cliente> updateCelularCli(@PathVariable("id") Long id, @RequestBody String celular) {
    Optional<Cliente> optCli = clienteService.updateCelular(id, celular);
    if (optCli.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(optCli.get(), HttpStatus.OK);
  }

  @PutMapping("/actualizar-direccion/{id}")
  public ResponseEntity<Cliente> updateDireccionCli(@PathVariable("id") Long id, @RequestBody String direccion) {
    Optional<Cliente> optCli = clienteService.updateDireccion(id, direccion);
    if (optCli.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(optCli.get(), HttpStatus.OK);
  }

  @GetMapping("/encontrar/{id}")
  public ResponseEntity<Cliente> findByIDCli(@PathVariable("id") Long id) {
    Optional<Cliente> optAni = clienteService.findByID(id);
    if (optAni.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(optAni.get(), HttpStatus.OK);
  }

  @DeleteMapping("/eliminar/{id}")
  public ResponseEntity<Void> deleteCli(@PathVariable("id") Long id) {
    boolean isDeleted = clienteService.delete(id);
    if (!isDeleted) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
