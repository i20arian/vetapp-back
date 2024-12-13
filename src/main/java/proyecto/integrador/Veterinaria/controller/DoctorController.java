package proyecto.integrador.Veterinaria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.integrador.Veterinaria.entity.Doctor;
import proyecto.integrador.Veterinaria.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Doctor>> getAllDoctores() {
        List<Doctor> doctores = doctorService.getAllDoctores();
        return doctores.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(doctores, HttpStatus.OK);
    }

    @PostMapping("/insertar")
    public ResponseEntity<Doctor> insertarDoctor(@RequestBody Doctor doctor) {
        Doctor nuevoDoctor = doctorService.insertarDoctor(doctor);
        return new ResponseEntity<>(nuevoDoctor, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Doctor> actualizarDoctor(@PathVariable("id") Integer id, @RequestBody Doctor doctor) {
        try {
            Doctor doctorActualizado = doctorService.actualizarDoctor(id, doctor);
            return new ResponseEntity<>(doctorActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarDoctor(@PathVariable("id") Integer id) {
        try {
            doctorService.eliminarDoctor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
