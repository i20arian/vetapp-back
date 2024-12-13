package proyecto.integrador.Veterinaria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int codigoDoctor;

  private String nombreDoctor;

  private String apellidoDoctor;

  private int dniDoctor;

  private String especialidad;

  private String experiencia;

  public Doctor() {
  }

  public Doctor(int codigoDoctor, String nombreDoctor, int dniDoctor, String apellidoDoctor, String especialidad,
      String experiencia) {
    this.codigoDoctor = codigoDoctor;
    this.nombreDoctor = nombreDoctor;
    this.dniDoctor = dniDoctor;
    this.apellidoDoctor = apellidoDoctor;
    this.especialidad = especialidad;
    this.experiencia = experiencia;
  }

  public int getCodigoDoctor() {
    return codigoDoctor;
  }

  public void setCodigoDoctor(int codigoDoctor) {
    this.codigoDoctor = codigoDoctor;
  }

  public String getNombreDoctor() {
    return nombreDoctor;
  }

  public void setNombreDoctor(String nombreDoctor) {
    this.nombreDoctor = nombreDoctor;
  }

  public String getApellidoDoctor() {
    return apellidoDoctor;
  }

  public void setApellidoDoctor(String apellidoDoctor) {
    this.apellidoDoctor = apellidoDoctor;
  }

  public int getDniDoctor() {
    return dniDoctor;
  }

  public void setDniDoctor(int dniDoctor) {
    this.dniDoctor = dniDoctor;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public String getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(String experiencia) {
    this.experiencia = experiencia;
  }
}
