/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "ofi_edificio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfiEdificio.findAll", query = "SELECT o FROM OfiEdificio o")})
public class OfiEdificio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_edificio")
    private String codEdificio;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cod_alterno")
    private String codAlterno;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @Column(name = "maneja_bloques")
    private String manejaBloques;
    @Basic(optional = false)
    @Column(name = "posee_aulas")
    private String poseeAulas;
    @Basic(optional = false)
    @Column(name = "pisos")
    private short pisos;
    @Basic(optional = false)
    @Column(name = "aud_usuario")
    private String audUsuario;
    @Basic(optional = false)
    @Column(name = "aud_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Basic(optional = false)
    @Column(name = "aud_ip")
    private String audIp;
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    @JoinColumn(name = "cod_sede", referencedColumnName = "cod_sede")
    @ManyToOne
    private OfiSede codSede;
    @OneToMany(mappedBy = "codEdificio")
    private List<OfiEdificioBloque> ofiEdificioBloqueList;
    @OneToMany(mappedBy = "codEdificio")
    private List<OfiAula> ofiAulaList;

    public OfiEdificio() {
    }

    public OfiEdificio(String codEdificio) {
        this.codEdificio = codEdificio;
    }

    public OfiEdificio(String codEdificio, String nombre, String descripcion, String direccion, String manejaBloques, String poseeAulas, short pisos, String audUsuario, Date audFecha, String audIp, int version) {
        this.codEdificio = codEdificio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.manejaBloques = manejaBloques;
        this.poseeAulas = poseeAulas;
        this.pisos = pisos;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public String getCodEdificio() {
        return codEdificio;
    }

    public void setCodEdificio(String codEdificio) {
        this.codEdificio = codEdificio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodAlterno() {
        return codAlterno;
    }

    public void setCodAlterno(String codAlterno) {
        this.codAlterno = codAlterno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getManejaBloques() {
        return manejaBloques;
    }

    public void setManejaBloques(String manejaBloques) {
        this.manejaBloques = manejaBloques;
    }

    public String getPoseeAulas() {
        return poseeAulas;
    }

    public void setPoseeAulas(String poseeAulas) {
        this.poseeAulas = poseeAulas;
    }

    public short getPisos() {
        return pisos;
    }

    public void setPisos(short pisos) {
        this.pisos = pisos;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public OfiSede getCodSede() {
        return codSede;
    }

    public void setCodSede(OfiSede codSede) {
        this.codSede = codSede;
    }

    @XmlTransient
    public List<OfiEdificioBloque> getOfiEdificioBloqueList() {
        return ofiEdificioBloqueList;
    }

    public void setOfiEdificioBloqueList(List<OfiEdificioBloque> ofiEdificioBloqueList) {
        this.ofiEdificioBloqueList = ofiEdificioBloqueList;
    }

    @XmlTransient
    public List<OfiAula> getOfiAulaList() {
        return ofiAulaList;
    }

    public void setOfiAulaList(List<OfiAula> ofiAulaList) {
        this.ofiAulaList = ofiAulaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEdificio != null ? codEdificio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfiEdificio)) {
            return false;
        }
        OfiEdificio other = (OfiEdificio) object;
        if ((this.codEdificio == null && other.codEdificio != null) || (this.codEdificio != null && !this.codEdificio.equals(other.codEdificio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.OfiEdificio[ codEdificio=" + codEdificio + " ]";
    }
    
}
