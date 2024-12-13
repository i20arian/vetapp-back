package proyecto.integrador.Veterinaria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medico {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int codigoDoctor;

  private String nombreDoctor;

  private String apellidoDoctor;

  private int dniDoctor;

  private String especialidad;

  private String experiencia;
}
