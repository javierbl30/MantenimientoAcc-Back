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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "materiales", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiales.findAll", query = "SELECT m FROM Materiales m")
    , @NamedQuery(name = "Materiales.findByCodmaterial", query = "SELECT m FROM Materiales m WHERE m.codmaterial = :codmaterial")
    , @NamedQuery(name = "Materiales.findByNombre", query = "SELECT m FROM Materiales m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Materiales.findByDescripcion", query = "SELECT m FROM Materiales m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Materiales.findByCantidad", query = "SELECT m FROM Materiales m WHERE m.cantidad = :cantidad")
    , @NamedQuery(name = "Materiales.findByCosto", query = "SELECT m FROM Materiales m WHERE m.costo = :costo")})
public class Materiales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codmaterial", nullable = false, length = 10)
    private String codmaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Size(max = 150)
    @Column(name = "descripcion", length = 150)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo", nullable = false)
    private long costo;
    @JoinTable(name = "materialesprocedimiento", joinColumns = {
        @JoinColumn(name = "codmaterial", referencedColumnName = "codmaterial", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "idprocedimiento", referencedColumnName = "idprocedimiento", nullable = false)})
    @ManyToMany
    private List<Procedimiento> procedimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmaterial")
    private List<Ordencompra> ordencompraList;
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor", nullable = false)
    @ManyToOne(optional = false)
    private Proveedores idproveedor;

    public Materiales() {
    }

    public Materiales(String codmaterial) {
        this.codmaterial = codmaterial;
    }

    public Materiales(String codmaterial, String nombre, int cantidad, long costo) {
        this.codmaterial = codmaterial;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public String getCodmaterial() {
        return codmaterial;
    }

    public void setCodmaterial(String codmaterial) {
        this.codmaterial = codmaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }

    @XmlTransient
    @JsonbTransient
    public List<Procedimiento> getProcedimientoList() {
        return procedimientoList;
    }

    public void setProcedimientoList(List<Procedimiento> procedimientoList) {
        this.procedimientoList = procedimientoList;
    }

    @XmlTransient
    @JsonbTransient
    public List<Ordencompra> getOrdencompraList() {
        return ordencompraList;
    }

    public void setOrdencompraList(List<Ordencompra> ordencompraList) {
        this.ordencompraList = ordencompraList;
    }

    public Proveedores getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Proveedores idproveedor) {
        this.idproveedor = idproveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmaterial != null ? codmaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiales)) {
            return false;
        }
        Materiales other = (Materiales) object;
        if ((this.codmaterial == null && other.codmaterial != null) || (this.codmaterial != null && !this.codmaterial.equals(other.codmaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Materiales[ codmaterial=" + codmaterial + " ]";
    }
    
}
