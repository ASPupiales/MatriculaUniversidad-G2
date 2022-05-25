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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "gen_ubicacion_geografica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenUbicacionGeografica.findAll", query = "SELECT g FROM GenUbicacionGeografica g")})
public class GenUbicacionGeografica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ubicacion_geo_int")
    private Integer codUbicacionGeoInt;
    @Basic(optional = false)
    @Column(name = "cod_ubicacion_geografica")
    private String codUbicacionGeografica;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "codigo_area_telefono")
    private String codigoAreaTelefono;
    @Column(name = "codigo_alterno")
    private String codigoAlterno;
    @Column(name = "codigo_postal")
    private String codigoPostal;
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
    @OneToMany(mappedBy = "codUbicacionGeoInt")
    private List<GenInstitucion> genInstitucionList;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne
    private GenPais codPais;
    @JoinColumns({
        @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais"),
        @JoinColumn(name = "nivel", referencedColumnName = "nivel")})
    @ManyToOne(optional = false)
    private GenPaisEstructura genPaisEstructura;
    @OneToMany(mappedBy = "codUbicacionGeoPadre")
    private List<GenUbicacionGeografica> genUbicacionGeograficaList;
    @JoinColumn(name = "cod_ubicacion_geo_padre", referencedColumnName = "cod_ubicacion_geo_int")
    @ManyToOne
    private GenUbicacionGeografica codUbicacionGeoPadre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lugarNacimiento")
    private List<PerPersona> perPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUbicacionGeoInt")
    private List<EduInstitucionEducativa> eduInstitucionEducativaList;

    public GenUbicacionGeografica() {
    }

    public GenUbicacionGeografica(Integer codUbicacionGeoInt) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
    }

    public GenUbicacionGeografica(Integer codUbicacionGeoInt, String codUbicacionGeografica, String nombre, String audUsuario, Date audFecha, String audIp, int version) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
        this.codUbicacionGeografica = codUbicacionGeografica;
        this.nombre = nombre;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public Integer getCodUbicacionGeoInt() {
        return codUbicacionGeoInt;
    }

    public void setCodUbicacionGeoInt(Integer codUbicacionGeoInt) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
    }

    public String getCodUbicacionGeografica() {
        return codUbicacionGeografica;
    }

    public void setCodUbicacionGeografica(String codUbicacionGeografica) {
        this.codUbicacionGeografica = codUbicacionGeografica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoAreaTelefono() {
        return codigoAreaTelefono;
    }

    public void setCodigoAreaTelefono(String codigoAreaTelefono) {
        this.codigoAreaTelefono = codigoAreaTelefono;
    }

    public String getCodigoAlterno() {
        return codigoAlterno;
    }

    public void setCodigoAlterno(String codigoAlterno) {
        this.codigoAlterno = codigoAlterno;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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

    @XmlTransient
    public List<GenInstitucion> getGenInstitucionList() {
        return genInstitucionList;
    }

    public void setGenInstitucionList(List<GenInstitucion> genInstitucionList) {
        this.genInstitucionList = genInstitucionList;
    }

    public GenPais getCodPais() {
        return codPais;
    }

    public void setCodPais(GenPais codPais) {
        this.codPais = codPais;
    }

    public GenPaisEstructura getGenPaisEstructura() {
        return genPaisEstructura;
    }

    public void setGenPaisEstructura(GenPaisEstructura genPaisEstructura) {
        this.genPaisEstructura = genPaisEstructura;
    }

    @XmlTransient
    public List<GenUbicacionGeografica> getGenUbicacionGeograficaList() {
        return genUbicacionGeograficaList;
    }

    public void setGenUbicacionGeograficaList(List<GenUbicacionGeografica> genUbicacionGeograficaList) {
        this.genUbicacionGeograficaList = genUbicacionGeograficaList;
    }

    public GenUbicacionGeografica getCodUbicacionGeoPadre() {
        return codUbicacionGeoPadre;
    }

    public void setCodUbicacionGeoPadre(GenUbicacionGeografica codUbicacionGeoPadre) {
        this.codUbicacionGeoPadre = codUbicacionGeoPadre;
    }

    @XmlTransient
    public List<PerPersona> getPerPersonaList() {
        return perPersonaList;
    }

    public void setPerPersonaList(List<PerPersona> perPersonaList) {
        this.perPersonaList = perPersonaList;
    }

    @XmlTransient
    public List<EduInstitucionEducativa> getEduInstitucionEducativaList() {
        return eduInstitucionEducativaList;
    }

    public void setEduInstitucionEducativaList(List<EduInstitucionEducativa> eduInstitucionEducativaList) {
        this.eduInstitucionEducativaList = eduInstitucionEducativaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUbicacionGeoInt != null ? codUbicacionGeoInt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenUbicacionGeografica)) {
            return false;
        }
        GenUbicacionGeografica other = (GenUbicacionGeografica) object;
        if ((this.codUbicacionGeoInt == null && other.codUbicacionGeoInt != null) || (this.codUbicacionGeoInt != null && !this.codUbicacionGeoInt.equals(other.codUbicacionGeoInt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.GenUbicacionGeografica[ codUbicacionGeoInt=" + codUbicacionGeoInt + " ]";
    }
    
}