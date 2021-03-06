package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "edu_materia")
public class Materia implements Serializable {

    private static final long serialVersionUID = 104L;
    @EmbeddedId
    private MateriaPK pk;
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "creditos", nullable = false, precision = 4, scale = 2)
    private BigDecimal creditos;

    @Column(name = "horas", nullable = false, precision = 4, scale = 2)
    private BigDecimal horas;

    @Column(name = "ponderacion", nullable = false, precision = 5, scale = 2)
    private BigDecimal ponderacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private List<Prerequisito> prerequisitos;

    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Departamento departamento;

    public Materia() {
    }

    public Materia(MateriaPK materiaPK) {
        this.pk = materiaPK;
    }

    public Materia(Integer codMateria, Integer codDepartamento) {
        this.pk = new MateriaPK(codMateria, codDepartamento);
    }

    public MateriaPK getPk() {
        return pk;
    }

    public void setPk(MateriaPK pk) {
        this.pk = pk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCreditos() {
        return creditos;
    }

    public void setCreditos(BigDecimal creditos) {
        this.creditos = creditos;
    }

    public BigDecimal getHoras() {
        return horas;
    }

    public void setHoras(BigDecimal horas) {
        this.horas = horas;
    }

    public BigDecimal getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(BigDecimal ponderacion) {
        this.ponderacion = ponderacion;
    }

    public List<Prerequisito> getPrerequisitos() {
        return prerequisitos;
    }

    public void setPrerequisitos(List<Prerequisito> prerequisitos) {
        this.prerequisitos = prerequisitos;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "materiaPK=" + pk;
    }

}
