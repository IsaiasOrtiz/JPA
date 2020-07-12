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
@Table(name = "SRH_EC_ESTADO_CIVIL", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "SrhEcEstadoCivil.findAll", query = "SELECT s FROM SrhEcEstadoCivil s"),
    @NamedQuery(name = "SrhEcEstadoCivil.findByEcId", query = "SELECT s FROM SrhEcEstadoCivil s WHERE s.ecId = :ecId"),
    @NamedQuery(name = "SrhEcEstadoCivil.findByEcNombre", query = "SELECT s FROM SrhEcEstadoCivil s WHERE s.ecNombre = :ecNombre"),
    @NamedQuery(name = "SrhEcEstadoCivil.findByAUsuarioModifica", query = "SELECT s FROM SrhEcEstadoCivil s WHERE s.aUsuarioModifica = :aUsuarioModifica"),
    @NamedQuery(name = "SrhEcEstadoCivil.findByAFechaModificacion", query = "SELECT s FROM SrhEcEstadoCivil s WHERE s.aFechaModificacion = :aFechaModificacion"),
    @NamedQuery(name = "SrhEcEstadoCivil.findByAUsuarioCrea", query = "SELECT s FROM SrhEcEstadoCivil s WHERE s.aUsuarioCrea = :aUsuarioCrea"),
    @NamedQuery(name = "SrhEcEstadoCivil.findByAFechaCreacion", query = "SELECT s FROM SrhEcEstadoCivil s WHERE s.aFechaCreacion = :aFechaCreacion")})
public class SrhEcEstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EC_ID", nullable = false)
    private Integer ecId;
    @Column(name = "EC_NOMBRE", length = 50)
    private String ecNombre;
    @Column(name = "A_USUARIO_MODIFICA")
    private Integer aUsuarioModifica;
    @Column(name = "A_FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @Column(name = "A_USUARIO_CREA")
    private Integer aUsuarioCrea;
    @Column(name = "A_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @OneToMany(mappedBy = "ecId", fetch = FetchType.LAZY)
    private List<SrhEpEmpleado> srhEpEmpleadoList;

    public SrhEcEstadoCivil() {
    }

    public SrhEcEstadoCivil(Integer ecId) {
        this.ecId = ecId;
    }

    public Integer getEcId() {
        return ecId;
    }

    public void setEcId(Integer ecId) {
        this.ecId = ecId;
    }

    public String getEcNombre() {
        return ecNombre;
    }

    public void setEcNombre(String ecNombre) {
        this.ecNombre = ecNombre;
    }

    public Integer getAUsuarioModifica() {
        return aUsuarioModifica;
    }

    public void setAUsuarioModifica(Integer aUsuarioModifica) {
        this.aUsuarioModifica = aUsuarioModifica;
    }

    public Date getAFechaModificacion() {
        return aFechaModificacion;
    }

    public void setAFechaModificacion(Date aFechaModificacion) {
        this.aFechaModificacion = aFechaModificacion;
    }

    public Integer getAUsuarioCrea() {
        return aUsuarioCrea;
    }

    public void setAUsuarioCrea(Integer aUsuarioCrea) {
        this.aUsuarioCrea = aUsuarioCrea;
    }

    public Date getAFechaCreacion() {
        return aFechaCreacion;
    }

    public void setAFechaCreacion(Date aFechaCreacion) {
        this.aFechaCreacion = aFechaCreacion;
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
        hash += (ecId != null ? ecId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrhEcEstadoCivil)) {
            return false;
        }
        SrhEcEstadoCivil other = (SrhEcEstadoCivil) object;
        if ((this.ecId == null && other.ecId != null) || (this.ecId != null && !this.ecId.equals(other.ecId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.SrhEcEstadoCivil[ ecId=" + ecId + " ]";
    }
    
}
