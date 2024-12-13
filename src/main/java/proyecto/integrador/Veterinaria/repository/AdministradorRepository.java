package proyecto.integrador.Veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.integrador.Veterinaria.entity.Administrador;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {
  Optional<Administrador> findByUsuario(String usuario);

  Optional<Administrador> findByGmail(String gmail);

  Optional<Administrador> findByUsuarioAndPassword(String usuario, String password);
}
