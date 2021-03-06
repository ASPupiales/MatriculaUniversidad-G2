package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "edu_malla_carrera")
public class MallaCarrera implements Serializable {

    private static final long serialVersionUID = 103L;
    @Id
    @Column(name = "cod_materiacarrera", nullable = false)
    private Integer codMateriaCarrera;
    
    @Column(name = "cod_carrera", nullable = false, insertable = false, updatable = false)
    private Integer codCarrera;
    
    @Column(name = "cod_materia", nullable = false, insertable = false, updatable = false)
    private Integer codMateria;
    
    @Column(name = "cod_departamento", nullable = false, insertable = false, updatable = false)
    private Integer codDepartamento;
    
    @Column(name = "nivel")
    private Integer nivel;
    
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod_carrera", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Carrera carrera;

    @JoinColumns({
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false)})
    @ManyToOne(optional = false)
    private Materia materia;

    public MallaCarrera() {
    }

    public MallaCarrera(Integer codMateriaCarrera) {
        this.codMateriaCarrera = codMateriaCarrera;
    }

    public Integer getCodMateriaCarrera() {
        return codMateriaCarrera;
    }

    public void setCodMateriaCarrera(Integer codMateriaCarrera) {
        this.codMateriaCarrera = codMateriaCarrera;
    }

    public Integer getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(Integer codMateria) {
        this.codMateria = codMateria;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }
    
    
    
    public Integer getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Integer codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMateriaCarrera != null ? codMateriaCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MallaCarrera)) {
            return false;
        }
        MallaCarrera other = (MallaCarrera) object;
        if ((this.codMateriaCarrera == null && other.codMateriaCarrera != null) || (this.codMateriaCarrera != null && !this.codMateriaCarrera.equals(other.codMateriaCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codMateriaCarrera=" + codMateriaCarrera;
    }

}
