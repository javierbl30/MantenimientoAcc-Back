/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pedrojv
 */
@Entity
@Table(name = "procedimientosmantenimiento", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimientosmantenimiento.findAll", query = "SELECT p FROM Procedimientosmantenimiento p")
    , @NamedQuery(name = "Procedimientosmantenimiento.findByIdpromant", query = "SELECT p FROM Procedimientosmantenimiento p WHERE p.idpromant = :idpromant")
    , @NamedQuery(name = "Procedimientosmantenimiento.findByDescripcion", query = "SELECT p FROM Procedimientosmantenimiento p WHERE p.descripcion = :descripcion")})
public class Procedimientosmantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idpromant", nullable = false, length = 10)
    private String idpromant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpromant")
    private List<Solicitudordentrabajo> solicitudordentrabajoList;

    public Procedimientosmantenimiento() {
    }

    public Procedimientosmantenimiento(String idpromant) {
        this.idpromant = idpromant;
    }

    public Procedimientosmantenimiento(String idpromant, String descripcion) {
        this.idpromant = idpromant;
        this.descripcion = descripcion;
    }

    public String getIdpromant() {
        return idpromant;
    }

    public void setIdpromant(String idpromant) {
        this.idpromant = idpromant;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    @JsonbTransient
    public List<Solicitudordentrabajo> getSolicitudordentrabajoList() {
        return solicitudordentrabajoList;
    }

    public void setSolicitudordentrabajoList(List<Solicitudordentrabajo> solicitudordentrabajoList) {
        this.solicitudordentrabajoList = solicitudordentrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpromant != null ? idpromant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimientosmantenimiento)) {
            return false;
        }
        Procedimientosmantenimiento other = (Procedimientosmantenimiento) object;
        if ((this.idpromant == null && other.idpromant != null) || (this.idpromant != null && !this.idpromant.equals(other.idpromant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Procedimientosmantenimiento[ idpromant=" + idpromant + " ]";
    }
    
}
