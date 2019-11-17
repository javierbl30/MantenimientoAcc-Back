/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pedrojv
 */
@Entity
@Table(name = "ordentrabajo", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordentrabajo.findAll", query = "SELECT o FROM Ordentrabajo o")
    , @NamedQuery(name = "Ordentrabajo.findByIdordentrabajo", query = "SELECT o FROM Ordentrabajo o WHERE o.idordentrabajo = :idordentrabajo")
    , @NamedQuery(name = "Ordentrabajo.findByFechafin", query = "SELECT o FROM Ordentrabajo o WHERE o.fechafin = :fechafin")})
public class Ordentrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idordentrabajo", nullable = false, length = 10)
    private String idordentrabajo;
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @JoinColumn(name = "idcalendario", referencedColumnName = "idcalendario", nullable = false)
    @ManyToOne(optional = false)
    private Calendario idcalendario;
    @JoinColumn(name = "idpem", referencedColumnName = "idpem", nullable = false)
    @ManyToOne(optional = false)
    private Pem idpem;
    @JoinColumn(name = "idsolicitud", referencedColumnName = "idsolicitud", nullable = false)
    @ManyToOne(optional = false)
    private Solicitudordentrabajo idsolicitud;
    @JoinColumn(name = "idstatus", referencedColumnName = "idstatus", nullable = false)
    @ManyToOne(optional = false)
    private Status idstatus;

    public Ordentrabajo() {
    }

    public Ordentrabajo(String idordentrabajo) {
        this.idordentrabajo = idordentrabajo;
    }

    public String getIdordentrabajo() {
        return idordentrabajo;
    }

    public void setIdordentrabajo(String idordentrabajo) {
        this.idordentrabajo = idordentrabajo;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Calendario getIdcalendario() {
        return idcalendario;
    }

    public void setIdcalendario(Calendario idcalendario) {
        this.idcalendario = idcalendario;
    }

    public Pem getIdpem() {
        return idpem;
    }

    public void setIdpem(Pem idpem) {
        this.idpem = idpem;
    }

    public Solicitudordentrabajo getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(Solicitudordentrabajo idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Status getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Status idstatus) {
        this.idstatus = idstatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idordentrabajo != null ? idordentrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordentrabajo)) {
            return false;
        }
        Ordentrabajo other = (Ordentrabajo) object;
        if ((this.idordentrabajo == null && other.idordentrabajo != null) || (this.idordentrabajo != null && !this.idordentrabajo.equals(other.idordentrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Ordentrabajo[ idordentrabajo=" + idordentrabajo + " ]";
    }
    
}
