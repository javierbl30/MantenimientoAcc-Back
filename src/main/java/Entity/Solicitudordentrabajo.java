/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pedrojv
 */
@Entity
@Table(name = "solicitudordentrabajo", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitudordentrabajo.findAll", query = "SELECT s FROM Solicitudordentrabajo s")
    , @NamedQuery(name = "Solicitudordentrabajo.findByIdsolicitud", query = "SELECT s FROM Solicitudordentrabajo s WHERE s.idsolicitud = :idsolicitud")
    , @NamedQuery(name = "Solicitudordentrabajo.findByNumero", query = "SELECT s FROM Solicitudordentrabajo s WHERE s.numero = :numero")
    , @NamedQuery(name = "Solicitudordentrabajo.findByFechasolicitud", query = "SELECT s FROM Solicitudordentrabajo s WHERE s.fechasolicitud = :fechasolicitud")
    , @NamedQuery(name = "Solicitudordentrabajo.findByTipofalla", query = "SELECT s FROM Solicitudordentrabajo s WHERE s.tipofalla = :tipofalla")
    , @NamedQuery(name = "Solicitudordentrabajo.findByDescripcion", query = "SELECT s FROM Solicitudordentrabajo s WHERE s.descripcion = :descripcion")})
public class Solicitudordentrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idsolicitud", nullable = false, length = 10)
    private String idsolicitud;
    @Column(name = "numero")
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechasolicitud", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechasolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipofalla", nullable = false)
    private long tipofalla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descripcion", nullable = false)
    private int descripcion;
    @JoinColumn(name = "codinventario", referencedColumnName = "codinventario", nullable = false)
    @ManyToOne(optional = false)
    private Inventario codinventario;
    @JoinColumn(name = "idpromant", referencedColumnName = "idpromant", nullable = false)
    @ManyToOne(optional = false)
    private Procedimientosmantenimiento idpromant;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuarios idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsolicitud")
    private List<Ordentrabajo> ordentrabajoList;

    public Solicitudordentrabajo() {
    }

    public Solicitudordentrabajo(String idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Solicitudordentrabajo(String idsolicitud, Date fechasolicitud, long tipofalla, int descripcion) {
        this.idsolicitud = idsolicitud;
        this.fechasolicitud = fechasolicitud;
        this.tipofalla = tipofalla;
        this.descripcion = descripcion;
    }

    public String getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(String idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFechasolicitud() {
        return fechasolicitud;
    }

    public void setFechasolicitud(Date fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }

    public long getTipofalla() {
        return tipofalla;
    }

    public void setTipofalla(long tipofalla) {
        this.tipofalla = tipofalla;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    public Inventario getCodinventario() {
        return codinventario;
    }

    public void setCodinventario(Inventario codinventario) {
        this.codinventario = codinventario;
    }

    public Procedimientosmantenimiento getIdpromant() {
        return idpromant;
    }

    public void setIdpromant(Procedimientosmantenimiento idpromant) {
        this.idpromant = idpromant;
    }

    public Usuarios getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    @JsonbTransient
    public List<Ordentrabajo> getOrdentrabajoList() {
        return ordentrabajoList;
    }

    public void setOrdentrabajoList(List<Ordentrabajo> ordentrabajoList) {
        this.ordentrabajoList = ordentrabajoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsolicitud != null ? idsolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitudordentrabajo)) {
            return false;
        }
        Solicitudordentrabajo other = (Solicitudordentrabajo) object;
        if ((this.idsolicitud == null && other.idsolicitud != null) || (this.idsolicitud != null && !this.idsolicitud.equals(other.idsolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Solicitudordentrabajo[ idsolicitud=" + idsolicitud + " ]";
    }
    
}
