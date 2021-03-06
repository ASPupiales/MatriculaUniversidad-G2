package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MateriaPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia, MateriaPK> {

    List<Materia> findByPkCodDepartamentoOrderByNombreAsc(Integer codDepartamento);

    List<Materia> findByNombreContainingIgnoreCaseOrderByNombreAsc(String nombrePattern);
}
