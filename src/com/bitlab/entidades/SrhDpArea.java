/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
@Entity
@Table(name = "SRH_DP_AREA", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "SrhDpArea.findAll", query = "SELECT s FROM SrhDpArea s"),
    @NamedQuery(name = "SrhDpArea.findByDpId", query = "SELECT s FROM SrhDpArea s WHERE s.dpId = :dpId"),
    @NamedQuery(name = "SrhDpArea.findByDpNombre", query = "SELECT s FROM SrhDpArea s WHERE s.dpNombre = :dpNombre"),
    @NamedQuery(name = "SrhDpArea.findByAUsuarioCrea", query = "SELECT s FROM SrhDpArea s WHERE s.aUsuarioCrea = :aUsuarioCrea"),
    @NamedQuery(name = "SrhDpArea.findByAFechaModificacion", query = "SELECT s FROM SrhDpArea s WHERE s.aFechaModificacion = :aFechaModificacion"),
    @NamedQuery(name = "SrhDpArea.findByAFechaCreacion", query = "SELECT s FROM SrhDpArea s WHERE s.aFechaCreacion = :aFechaCreacion"),
    @NamedQuery(name = "SrhDpArea.findByAUsuarioModifica", query = "SELECT s FROM SrhDpArea s WHERE s.aUsuarioModifica = :aUsuarioModifica")})
public class SrhDpArea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DP_ID", nullable = false)
    private Integer dpId;
    @Column(name = "DP_NOMBRE", length = 150)
    private String dpNombre;
    @Column(name = "A_USUARIO_CREA")
    private Integer aUsuarioCrea;
    @Column(name = "A_FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @Column(name = "A_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @Column(name = "A_USUARIO_MODIFICA")
    private Integer aUsuarioModifica;
    @JoinColumn(name = "SC_ID", referencedColumnName = "SC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SrhScSucursal scId;
    @OneToMany(mappedBy = "dpId", fetch = FetchType.LAZY)
    private List<SrhEpEmpleado> srhEpEmpleadoList;

    public SrhDpArea() {
    }

    public SrhDpArea(Integer dpId) {
        this.dpId = dpId;
    }

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }

    public String getDpNombre() {
        return dpNombre;
    }

    public void setDpNombre(String dpNombre) {
        this.dpNombre = dpNombre;
    }

    public Integer getAUsuarioCrea() {
        return aUsuarioCrea;
    }

    public void setAUsuarioCrea(Integer aUsuarioCrea) {
        this.aUsuarioCrea = aUsuarioCrea;
    }

    public Date getAFechaModificacion() {
        return aFechaModificacion;
    }

    public void setAFechaModificacion(Date aFechaModificacion) {
        this.aFechaModificacion = aFechaModificacion;
    }

    public Date getAFechaCreacion() {
        return aFechaCreacion;
    }

    public void setAFechaCreacion(Date aFechaCreacion) {
        this.aFechaCreacion = aFechaCreacion;
    }

    public Integer getAUsuarioModifica() {
        return aUsuarioModifica;
    }

    public void setAUsuarioModifica(Integer aUsuarioModifica) {
        this.aUsuarioModifica = aUsuarioModifica;
    }

    public SrhScSucursal getScId() {
        return scId;
    }

    public void setScId(SrhScSucursal scId) {
        this.scId = scId;
    }

    public List<SrhEpEmpleado> getSrhEpEmpleadoList() {
        return srhEpEmpleadoList;
    }

    public void setSrhEpEmpleadoList(List<SrhEpEmpleado> srhEpEmpleadoList) {
        this.srhEpEmpleadoList = srhEpEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dpId != null ? dpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrhDpArea)) {
            return false;
        }
        SrhDpArea other = (SrhDpArea) object;
        if ((this.dpId == null && other.dpId != null) || (this.dpId != null && !this.dpId.equals(other.dpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.SrhDpArea[ dpId=" + dpId + " ]";
    }
    
}
