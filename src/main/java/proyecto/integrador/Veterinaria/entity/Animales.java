package proyecto.integrador.Veterinaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_animales")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Animales {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codigoAnimal;
  private String nombreAnimal;
  private String dueno;
  private int edad;
  private double peso;
  private String informacionAnimal;
  private String generoAnim;
  private String tipoAnimal;
}
