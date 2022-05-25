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
@Table(name = "ofi_tipo_aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfiTipoAula.findAll", query = "SELECT o FROM OfiTipoAula o")})
public class OfiTipoAula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_tipo_aula")
    private String codTipoAula;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
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
    @OneToMany(mappedBy = "codTipoAula")
    private List<OfiAula> ofiAulaList;

    public OfiTipoAula() {
    }

    public OfiTipoAula(String codTipoAula) {
        this.codTipoAula = codTipoAula;
    }

    public OfiTipoAula(String codTipoAula, String descripcion, String audUsuario, Date audFecha, String audIp, int version) {
        this.codTipoAula = codTipoAula;
        this.descripcion = descripcion;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public String getCodTipoAula() {
        return codTipoAula;
    }

    public void setCodTipoAula(String codTipoAula) {
        this.codTipoAula = codTipoAula;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
        hash += (codTipoAula != null ? codTipoAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfiTipoAula)) {
            return false;
        }
        OfiTipoAula other = (OfiTipoAula) object;
        if ((this.codTipoAula == null && other.codTipoAula != null) || (this.codTipoAula != null && !this.codTipoAula.equals(other.codTipoAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.OfiTipoAula[ codTipoAula=" + codTipoAula + " ]";
    }
    
}