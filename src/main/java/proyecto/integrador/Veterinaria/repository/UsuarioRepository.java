package proyecto.integrador.Veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.integrador.Veterinaria.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsuario(String usuario);
    Optional<Usuario> findByGmail(String gmail);
    Optional<Usuario> findByUsuarioAndPassword(String usuario, String password);
}
