package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.escolastico.educacion.MallaCarreraException;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MallaCarrera;
import ec.edu.espe.arquitectura.escolastico.educacion.service.CarreraService;

@RestController
@RequestMapping(path = "/carrera")
public class CarreraResource {
    private CarreraService service;

    public CarreraResource(CarreraService service) {
        this.service = service;
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<List<Carrera>> getCarrerasByDepartamento(@PathVariable Integer codigo) {
        return ResponseEntity.ok(this.service.listarCarrerasPorDepartamento(codigo));
    }

    @GetMapping(value = "/nombre/{nombrePattern}")
    public ResponseEntity<List<Carrera>> getCarrerasByDepartamento(@PathVariable String nombrePattern) {
        return ResponseEntity.ok(this.service.listarCarrerasPorNombre(nombrePattern));
    }

    @GetMapping(value = "/siglas/{siglas}")
    public ResponseEntity<Carrera> getCarreraBySiglas(@PathVariable String siglas) {
        return ResponseEntity.ok(this.service.obtenerPorSiglas(siglas));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Carrera carrera) {
        try {
            this.service.crear(carrera);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Carrera> modificar(@RequestBody Carrera carrera) {
        try {
            this.service.modificar(carrera);
            carrera = this.service.obtenerPorCodigo(carrera.getCodDepartamento());
            return ResponseEntity.ok(carrera);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/malla/{codigo}")
    public ResponseEntity<List<MallaCarrera>> obtenerMalla(@PathVariable Integer codigo) throws MallaCarreraException {
        return ResponseEntity.ok(this.service.obtenerMalla(codigo));
    }

    @GetMapping(value = "/malla/nivel/{codigo}/{nivel}")
    public ResponseEntity<List<MallaCarrera>> obtenerMateriasYNivel(@PathVariable Integer codigo, @PathVariable Integer nivel) throws MallaCarreraException {
        return ResponseEntity.ok(this.service.obtenerMateriasPorNivel(codigo, nivel));
    }

    @PutMapping(value = "/materia")
    public ResponseEntity<String> modificarMateriaMalla(@RequestBody MallaCarrera materiaCarrera) {
        try {
            this.service.modificarMateriaMallaCarrera(materiaCarrera);
            materiaCarrera = this.service.obtenerMallaCarreraPorCodigo(materiaCarrera.getCodMateriaCarrera());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
}
