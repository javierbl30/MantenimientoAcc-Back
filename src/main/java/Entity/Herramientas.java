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
@Table(name = "herramientas", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Herramientas.findAll", query = "SELECT h FROM Herramientas h")
    , @NamedQuery(name = "Herramientas.findByIdherramienta", query = "SELECT h FROM Herramientas h WHERE h.idherramienta = :idherramienta")
    , @NamedQuery(name = "Herramientas.findByNombre", query = "SELECT h FROM Herramientas h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "Herramientas.findByCantidad", query = "SELECT h FROM Herramientas h WHERE h.cantidad = :cantidad")})
public class Herramientas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idherramienta", nullable = false)
    private Integer idherramienta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @JoinTable(name = "herramientasprocedimiento", joinColumns = {
        @JoinColumn(name = "idherramienta", referencedColumnName = "idherramienta", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "idprocedimiento", referencedColumnName = "idprocedimiento", nullable = false)})
    @ManyToMany
    private List<Procedimiento> procedimientoList;

    public Herramientas() {
    }

    public Herramientas(Integer idherramienta) {
        this.idherramienta = idherramienta;
    }

    public Herramientas(Integer idherramienta, String nombre, int cantidad) {
        this.idherramienta = idherramienta;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Integer getIdherramienta() {
        return idherramienta;
    }

    public void setIdherramienta(Integer idherramienta) {
        this.idherramienta = idherramienta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        hash += (idherramienta != null ? idherramienta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Herramientas)) {
            return false;
        }
        Herramientas other = (Herramientas) object;
        if ((this.idherramienta == null && other.idherramienta != null) || (this.idherramienta != null && !this.idherramienta.equals(other.idherramienta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Herramientas[ idherramienta=" + idherramienta + " ]";
    }
    
}
