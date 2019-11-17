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
@Table(name = "ordencompra", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordencompra.findAll", query = "SELECT o FROM Ordencompra o")
    , @NamedQuery(name = "Ordencompra.findByIdcompra", query = "SELECT o FROM Ordencompra o WHERE o.idcompra = :idcompra")
    , @NamedQuery(name = "Ordencompra.findByCantidad", query = "SELECT o FROM Ordencompra o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "Ordencompra.findByFecha", query = "SELECT o FROM Ordencompra o WHERE o.fecha = :fecha")})
public class Ordencompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idcompra", nullable = false, length = 10)
    private String idcompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "codmaterial", referencedColumnName = "codmaterial", nullable = false)
    @ManyToOne(optional = false)
    private Materiales codmaterial;
    @JoinColumn(name = "idstatus", referencedColumnName = "idstatus", nullable = false)
    @ManyToOne(optional = false)
    private Status idstatus;

    public Ordencompra() {
    }

    public Ordencompra(String idcompra) {
        this.idcompra = idcompra;
    }

    public Ordencompra(String idcompra, int cantidad, Date fecha) {
        this.idcompra = idcompra;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public String getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(String idcompra) {
        this.idcompra = idcompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Materiales getCodmaterial() {
        return codmaterial;
    }

    public void setCodmaterial(Materiales codmaterial) {
        this.codmaterial = codmaterial;
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
        hash += (idcompra != null ? idcompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordencompra)) {
            return false;
        }
        Ordencompra other = (Ordencompra) object;
        if ((this.idcompra == null && other.idcompra != null) || (this.idcompra != null && !this.idcompra.equals(other.idcompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Ordencompra[ idcompra=" + idcompra + " ]";
    }
    
}
