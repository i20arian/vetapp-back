package proyecto.integrador.Veterinaria.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@Data
@Table(name = "animales")
public class Animales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoAnimal;  // ID del animal, se usa Long si es autoincrementable

    private String nombreAnimal;
    private String dueno;
    private int edad;
    private double peso;
    private String informacionAnimal;
    private String generoAnim;
    private String tipoAnimal;

    public Animales(Long codigoAnimal, String dueno, String nombreAnimal, int edad, String informacionAnimal, double peso, String generoAnim, String tipoAnimal) {
        this.codigoAnimal = codigoAnimal;
        this.dueno = dueno;
        this.nombreAnimal = nombreAnimal;
        this.edad = edad;
        this.informacionAnimal = informacionAnimal;
        this.peso = peso;
        this.generoAnim = generoAnim;
        this.tipoAnimal = tipoAnimal;
    }

    public  Animales(){}

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public Long getCodigoAnimal() {
        return codigoAnimal;
    }

    public void setCodigoAnimal(Long codigoAnimal) {
        this.codigoAnimal = codigoAnimal;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getInformacionAnimal() {
        return informacionAnimal;
    }

    public void setInformacionAnimal(String informacionAnimal) {
        this.informacionAnimal = informacionAnimal;
    }

    public String getGeneroAnim() {
        return generoAnim;
    }

    public void setGeneroAnim(String generoAnim) {
        this.generoAnim = generoAnim;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
}
