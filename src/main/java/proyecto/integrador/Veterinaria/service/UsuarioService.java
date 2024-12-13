package proyecto.integrador.Veterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.integrador.Veterinaria.entity.Usuario;
import proyecto.integrador.Veterinaria.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {
  @Autowired
  private UsuarioRepository usuarioRepository;

  public Optional<Usuario> login(String usuario, String password) {
    return usuarioRepository.findByUsuarioAndPassword(usuario, password);
  }

  public Usuario registrarUsuario(Usuario usuario) {
    // Verificar si el nombre de usuario ya existe
    if (usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent()) {
      throw new IllegalArgumentException("El nombre de usuario ya está registrado");
    }
    // Verificar si el correo ya está registrado
    if (usuarioRepository.findByGmail(usuario.getGmail()).isPresent()) {
      throw new IllegalArgumentException("El correo electrónico ya está registrado");
    }
    // Guardar el usuario en la base de datos
    return usuarioRepository.save(usuario);
  }
}
