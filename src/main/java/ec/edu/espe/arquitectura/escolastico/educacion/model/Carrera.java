package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "edu_carrera")
public class Carrera implements Serializable {

    private static final long serialVersionUID = 101L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_carrera", nullable = false)
    private Integer codCarrera;
    
    @Column(name = "cod_departamento", nullable = false, insertable = false, updatable = false)
    private Integer codDepartamento;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "total_semestres", nullable = false)
    private Integer totalSemestres;

    @Column(name = "grado", nullable = false, length = 25)
    private String grado;

    @Column(name = "perfil_profesional", nullable = false, length = 500)
    private String perfilProfesional;

    @Column(name = "nivel", nullable = false, length = 32)
    private String nivel;

    @Column(name = "total_creditos", nullable = false, precision = 5, scale = 2)
    private BigDecimal totalCreditos;

    @Column(name = "total_horas", nullable = false, precision = 5, scale = 2)
    private BigDecimal totalHoras;

    @Column(name = "siglas", nullable = false, length = 32)
    private String siglas;

    @Column(name = "precio_credito", nullable = false, precision = 5, scale = 2)
    private BigDecimal precioCredito;

    @Column(name = "modalidad", length = 64)
    private String modalidad;

    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Departamento departamento;

    public Carrera() {
    }

    public Carrera(Integer codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Integer getCodCarrera() {
        return codCarrera;
    }
    
    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public void setCodCarrera(Integer codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTotalSemestres() {
        return totalSemestres;
    }

    public void setTotalSemestres(Integer totalSemestres) {
        this.totalSemestres = totalSemestres;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getPerfilProfesional() {
        return perfilProfesional;
    }

    public void setPerfilProfesional(String perfilProfesional) {
        this.perfilProfesional = perfilProfesional;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public BigDecimal getTotalCreditos() {
        return totalCreditos;
    }

    public void setTotalCreditos(BigDecimal totalCreditos) {
        this.totalCreditos = totalCreditos;
    }

    public BigDecimal getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(BigDecimal totalHoras) {
        this.totalHoras = totalHoras;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public BigDecimal getPrecioCredito() {
        return precioCredito;
    }

    public void setPrecioCredito(BigDecimal precioCredito) {
        this.precioCredito = precioCredito;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
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
        hash += (codCarrera != null ? codCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.codCarrera == null && other.codCarrera != null) || (this.codCarrera != null && !this.codCarrera.equals(other.codCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codCarrera=" + codCarrera;
    }

}
