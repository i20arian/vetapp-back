package pi.vetapp.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_historia_clinica")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HistoriaClinica {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_hc")
  private Long id;

  @Column(name = "fecha_registro_hc", nullable = false)
  private LocalDate fechaDeRegistro;

  @Column(name = "hora_registro_hc", nullable = false)
  private LocalTime horaDeRegistro;

  @ManyToOne
  @JoinColumn(name = "id_ani", nullable = false)
  private Animal animal;

  @ManyToOne
  @JoinColumn(name = "id_cli", nullable = false)
  private Cliente cliente;

  @ManyToOne
  @JoinColumn(name = "id_med", nullable = false)
  private Medico medico;
}
