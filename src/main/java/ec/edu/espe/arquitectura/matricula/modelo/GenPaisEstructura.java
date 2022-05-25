/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "gen_pais_estructura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenPaisEstructura.findAll", query = "SELECT g FROM GenPaisEstructura g")})
public class GenPaisEstructura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GenPaisEstructuraPK genPaisEstructuraPK;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
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
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GenPais genPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genPaisEstructura")
    private List<GenUbicacionGeografica> genUbicacionGeograficaList;

    public GenPaisEstructura() {
    }

    public GenPaisEstructura(GenPaisEstructuraPK genPaisEstructuraPK) {
        this.genPaisEstructuraPK = genPaisEstructuraPK;
    }

    public GenPaisEstructura(GenPaisEstructuraPK genPaisEstructuraPK, String nombre, String audUsuario, Date audFecha, String audIp, int version) {
        this.genPaisEstructuraPK = genPaisEstructuraPK;
        this.nombre = nombre;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public GenPaisEstructura(String codPais, short nivel) {
        this.genPaisEstructuraPK = new GenPaisEstructuraPK(codPais, nivel);
    }

    public GenPaisEstructuraPK getGenPaisEstructuraPK() {
        return genPaisEstructuraPK;
    }

    public void setGenPaisEstructuraPK(GenPaisEstructuraPK genPaisEstructuraPK) {
        this.genPaisEstructuraPK = genPaisEstructuraPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public GenPais getGenPais() {
        return genPais;
    }

    public void setGenPais(GenPais genPais) {
        this.genPais = genPais;
    }

    @XmlTransient
    public List<GenUbicacionGeografica> getGenUbicacionGeograficaList() {
        return genUbicacionGeograficaList;
    }

    public void setGenUbicacionGeograficaList(List<GenUbicacionGeografica> genUbicacionGeograficaList) {
        this.genUbicacionGeograficaList = genUbicacionGeograficaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genPaisEstructuraPK != null ? genPaisEstructuraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenPaisEstructura)) {
            return false;
        }
        GenPaisEstructura other = (GenPaisEstructura) object;
        if ((this.genPaisEstructuraPK == null && other.genPaisEstructuraPK != null) || (this.genPaisEstructuraPK != null && !this.genPaisEstructuraPK.equals(other.genPaisEstructuraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.GenPaisEstructura[ genPaisEstructuraPK=" + genPaisEstructuraPK + " ]";
    }
    
}