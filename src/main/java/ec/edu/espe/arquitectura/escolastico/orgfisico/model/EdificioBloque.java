package ec.edu.espe.arquitectura.escolastico.orgfisico.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "ofi_edificio_bloque")
public class EdificioBloque implements Serializable {

    private static final long serialVersionUID = 119L;
    @Id
    @Column(name = "cod_edificio_bloque", nullable = false, length = 8)
    private String codEdificioBloque;
    
    @Column(name = "cod_edificio", nullable = false, length = 8)
    private String codEdificio;

    @Column(name = "nombre_bloque", nullable = false, length = 128)
    private String nombreBloque;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;

    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;

    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;

    @Column(name = "version", nullable = false)
    @Version
    private Integer version;

    @JoinColumn(name = "cod_edificio", referencedColumnName = "cod_edificio", insertable = false, updatable = false)
    @ManyToOne
    private Edificio edificio;

    public EdificioBloque() {
    }

    public EdificioBloque(String codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }

    public String getCodEdificioBloque() {
        return codEdificioBloque;
    }

    public void setCodEdificioBloque(String codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }

    public String getCodEdificio() {
        return codEdificio;
    }

    public void setCodEdificio(String codEdificio) {
        this.codEdificio = codEdificio;
    }

    public String getNombreBloque() {
        return nombreBloque;
    }

    public void setNombreBloque(String nombreBloque) {
        this.nombreBloque = nombreBloque;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAudUsuario() {
        return audUsuario;
    }

    public void setAudUsuario(String audUsuario) {
        this.audUsuario = audUsuario;
    }

    public Date getAudFecha() {
        return audFecha;
    }

    public void setAudFecha(Date audFecha) {
        this.audFecha = audFecha;
    }

    public String getAudIp() {
        return audIp;
    }

    public void setAudIp(String audIp) {
        this.audIp = audIp;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEdificioBloque != null ? codEdificioBloque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EdificioBloque)) {
            return false;
        }
        EdificioBloque other = (EdificioBloque) object;
        if ((this.codEdificioBloque == null && other.codEdificioBloque != null) || (this.codEdificioBloque != null && !this.codEdificioBloque.equals(other.codEdificioBloque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codEdificioBloque=" + codEdificioBloque;
    }

}
