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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pedrojv
 */
@Entity
@Table(name = "pem", catalog = "mantenimiento", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idusuario"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pem.findAll", query = "SELECT p FROM Pem p")
    , @NamedQuery(name = "Pem.findByIdpem", query = "SELECT p FROM Pem p WHERE p.idpem = :idpem")})
public class Pem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpem", nullable = false)
    private Integer idpem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpem")
    private List<Ordentrabajo> ordentrabajoList;
    @JoinColumn(name = "idprocedimiento", referencedColumnName = "idprocedimiento", nullable = false)
    @ManyToOne(optional = false)
    private Procedimiento idprocedimiento;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", nullable = false)
    @OneToOne(optional = false)
    private Usuarios idusuario;

    public Pem() {
    }

    public Pem(Integer idpem) {
        this.idpem = idpem;
    }

    public Integer getIdpem() {
        return idpem;
    }

    public void setIdpem(Integer idpem) {
        this.idpem = idpem;
    }

    @XmlTransient
    @JsonbTransient
    public List<Ordentrabajo> getOrdentrabajoList() {
        return ordentrabajoList;
    }

    public void setOrdentrabajoList(List<Ordentrabajo> ordentrabajoList) {
        this.ordentrabajoList = ordentrabajoList;
    }

    public Procedimiento getIdprocedimiento() {
        return idprocedimiento;
    }

    public void setIdprocedimiento(Procedimiento idprocedimiento) {
        this.idprocedimiento = idprocedimiento;
    }

    public Usuarios getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpem != null ? idpem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pem)) {
            return false;
        }
        Pem other = (Pem) object;
        if ((this.idpem == null && other.idpem != null) || (this.idpem != null && !this.idpem.equals(other.idpem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Pem[ idpem=" + idpem + " ]";
    }
    
}
