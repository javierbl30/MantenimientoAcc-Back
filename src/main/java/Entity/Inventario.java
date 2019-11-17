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
@Table(name = "inventario", catalog = "mantenimiento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
    , @NamedQuery(name = "Inventario.findByCodinventario", query = "SELECT i FROM Inventario i WHERE i.codinventario = :codinventario")
    , @NamedQuery(name = "Inventario.findByNombre", query = "SELECT i FROM Inventario i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Inventario.findByDescripcion", query = "SELECT i FROM Inventario i WHERE i.descripcion = :descripcion")
    , @NamedQuery(name = "Inventario.findByModelo", query = "SELECT i FROM Inventario i WHERE i.modelo = :modelo")
    , @NamedQuery(name = "Inventario.findByNumeroserie", query = "SELECT i FROM Inventario i WHERE i.numeroserie = :numeroserie")
    , @NamedQuery(name = "Inventario.findByAno", query = "SELECT i FROM Inventario i WHERE i.ano = :ano")
    , @NamedQuery(name = "Inventario.findByCondicion", query = "SELECT i FROM Inventario i WHERE i.condicion = :condicion")
    , @NamedQuery(name = "Inventario.findByUbicacion", query = "SELECT i FROM Inventario i WHERE i.ubicacion = :ubicacion")
    , @NamedQuery(name = "Inventario.findByVidautil", query = "SELECT i FROM Inventario i WHERE i.vidautil = :vidautil")
    , @NamedQuery(name = "Inventario.findByGarantia", query = "SELECT i FROM Inventario i WHERE i.garantia = :garantia")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codinventario", nullable = false, length = 10)
    private String codinventario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    @Size(max = 250)
    @Column(name = "descripcion", length = 250)
    private String descripcion;
    @Size(max = 100)
    @Column(name = "modelo", length = 100)
    private String modelo;
    @Size(max = 100)
    @Column(name = "numeroserie", length = 100)
    private String numeroserie;
    @Column(name = "ano")
    private Integer ano;
    @Size(max = 60)
    @Column(name = "condicion", length = 60)
    private String condicion;
    @Size(max = 100)
    @Column(name = "ubicacion", length = 100)
    private String ubicacion;
    @Column(name = "vidautil")
    private Integer vidautil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "garantia", nullable = false)
    private boolean garantia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codinventario")
    private List<Solicitudordentrabajo> solicitudordentrabajoList;

    public Inventario() {
    }

    public Inventario(String codinventario) {
        this.codinventario = codinventario;
    }

    public Inventario(String codinventario, String nombre, boolean garantia) {
        this.codinventario = codinventario;
        this.nombre = nombre;
        this.garantia = garantia;
    }

    public String getCodinventario() {
        return codinventario;
    }

    public void setCodinventario(String codinventario) {
        this.codinventario = codinventario;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getVidautil() {
        return vidautil;
    }

    public void setVidautil(Integer vidautil) {
        this.vidautil = vidautil;
    }

    public boolean getGarantia() {
        return garantia;
    }

    public void setGarantia(boolean garantia) {
        this.garantia = garantia;
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
        hash += (codinventario != null ? codinventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.codinventario == null && other.codinventario != null) || (this.codinventario != null && !this.codinventario.equals(other.codinventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Inventario[ codinventario=" + codinventario + " ]";
    }
    
}
