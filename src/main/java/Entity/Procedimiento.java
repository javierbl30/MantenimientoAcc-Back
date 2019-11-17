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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "procedimiento", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimiento.findAll", query = "SELECT p FROM Procedimiento p")
    , @NamedQuery(name = "Procedimiento.findByIdprocedimiento", query = "SELECT p FROM Procedimiento p WHERE p.idprocedimiento = :idprocedimiento")
    , @NamedQuery(name = "Procedimiento.findByProcedimiento", query = "SELECT p FROM Procedimiento p WHERE p.procedimiento = :procedimiento")})
public class Procedimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprocedimiento", nullable = false)
    private Integer idprocedimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "procedimiento", nullable = false, length = 250)
    private String procedimiento;
    @ManyToMany(mappedBy = "procedimientoList")
    private List<Materiales> materialesList;
    @ManyToMany(mappedBy = "procedimientoList")
    private List<Herramientas> herramientasList;
    @ManyToMany(mappedBy = "procedimientoList")
    private List<Pasos> pasosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprocedimiento")
    private List<Pem> pemList;

    public Procedimiento() {
    }

    public Procedimiento(Integer idprocedimiento) {
        this.idprocedimiento = idprocedimiento;
    }

    public Procedimiento(Integer idprocedimiento, String procedimiento) {
        this.idprocedimiento = idprocedimiento;
        this.procedimiento = procedimiento;
    }

    public Integer getIdprocedimiento() {
        return idprocedimiento;
    }

    public void setIdprocedimiento(Integer idprocedimiento) {
        this.idprocedimiento = idprocedimiento;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    @XmlTransient
    @JsonbTransient
    public List<Materiales> getMaterialesList() {
        return materialesList;
    }

    public void setMaterialesList(List<Materiales> materialesList) {
        this.materialesList = materialesList;
    }

    @XmlTransient
    @JsonbTransient
    public List<Herramientas> getHerramientasList() {
        return herramientasList;
    }

    public void setHerramientasList(List<Herramientas> herramientasList) {
        this.herramientasList = herramientasList;
    }

    @XmlTransient
    @JsonbTransient
    public List<Pasos> getPasosList() {
        return pasosList;
    }

    public void setPasosList(List<Pasos> pasosList) {
        this.pasosList = pasosList;
    }

    @XmlTransient
    @JsonbTransient
    public List<Pem> getPemList() {
        return pemList;
    }

    public void setPemList(List<Pem> pemList) {
        this.pemList = pemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprocedimiento != null ? idprocedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimiento)) {
            return false;
        }
        Procedimiento other = (Procedimiento) object;
        if ((this.idprocedimiento == null && other.idprocedimiento != null) || (this.idprocedimiento != null && !this.idprocedimiento.equals(other.idprocedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Procedimiento[ idprocedimiento=" + idprocedimiento + " ]";
    }
    
}
