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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "pasos", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasos.findAll", query = "SELECT p FROM Pasos p")
    , @NamedQuery(name = "Pasos.findByIdpaso", query = "SELECT p FROM Pasos p WHERE p.idpaso = :idpaso")
    , @NamedQuery(name = "Pasos.findByPaso", query = "SELECT p FROM Pasos p WHERE p.paso = :paso")})
public class Pasos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaso", nullable = false)
    private Integer idpaso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "paso", nullable = false, length = 500)
    private String paso;
    @JoinTable(name = "pasosprocedimientos", joinColumns = {
        @JoinColumn(name = "idpaso", referencedColumnName = "idpaso", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "idprocedimiento", referencedColumnName = "idprocedimiento", nullable = false)})
    @ManyToMany
    private List<Procedimiento> procedimientoList;

    public Pasos() {
    }

    public Pasos(Integer idpaso) {
        this.idpaso = idpaso;
    }

    public Pasos(Integer idpaso, String paso) {
        this.idpaso = idpaso;
        this.paso = paso;
    }

    public Integer getIdpaso() {
        return idpaso;
    }

    public void setIdpaso(Integer idpaso) {
        this.idpaso = idpaso;
    }

    public String getPaso() {
        return paso;
    }

    public void setPaso(String paso) {
        this.paso = paso;
    }

    @XmlTransient
    @JsonbTransient
    public List<Procedimiento> getProcedimientoList() {
        return procedimientoList;
    }

    public void setProcedimientoList(List<Procedimiento> procedimientoList) {
        this.procedimientoList = procedimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaso != null ? idpaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasos)) {
            return false;
        }
        Pasos other = (Pasos) object;
        if ((this.idpaso == null && other.idpaso != null) || (this.idpaso != null && !this.idpaso.equals(other.idpaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Pasos[ idpaso=" + idpaso + " ]";
    }
    
}
