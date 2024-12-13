package proyecto.integrador.Veterinaria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int codigoCliente;

  private String nombreCliente;

  private String apellidosCliente;

  private int dniCliente;

  private String informacionCliente;

  private String generoClie;

  public Cliente() {
  }

  public Cliente(int codigoCliente, String nombreCliente, String apellidosCliente, int dniCliente,
      String informacionCliente, String generoClie) {
    this.codigoCliente = codigoCliente;
    this.nombreCliente = nombreCliente;
    this.apellidosCliente = apellidosCliente;
    this.dniCliente = dniCliente;
    this.informacionCliente = informacionCliente;
    this.generoClie = generoClie;
  }

  public int getCodigoCliente() {
    return codigoCliente;
  }

  public void setCodigoCliente(int codigoCliente) {
    this.codigoCliente = codigoCliente;
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }

  public int getDniCliente() {
    return dniCliente;
  }

  public void setDniCliente(int dniCliente) {
    this.dniCliente = dniCliente;
  }

  public String getApellidosCliente() {
    return apellidosCliente;
  }

  public void setApellidosCliente(String apellidosCliente) {
    this.apellidosCliente = apellidosCliente;
  }

  public String getInformacionCliente() {
    return informacionCliente;
  }

  public void setInformacionCliente(String informacionCliente) {
    this.informacionCliente = informacionCliente;
  }

  public String getGeneroClie() {
    return generoClie;
  }

  public void setGeneroClie(String generoClie) {
    this.generoClie = generoClie;
  }
}
