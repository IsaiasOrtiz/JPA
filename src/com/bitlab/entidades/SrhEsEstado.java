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
@Table(name = "SRH_ES_ESTADO", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "SrhEsEstado.findAll", query = "SELECT s FROM SrhEsEstado s"),
    @NamedQuery(name = "SrhEsEstado.findByEsId", query = "SELECT s FROM SrhEsEstado s WHERE s.esId = :esId"),
    @NamedQuery(name = "SrhEsEstado.findByEsNombre", query = "SELECT s FROM SrhEsEstado s WHERE s.esNombre = :esNombre"),
    @NamedQuery(name = "SrhEsEstado.findByAFechaCreacion", query = "SELECT s FROM SrhEsEstado s WHERE s.aFechaCreacion = :aFechaCreacion"),
    @NamedQuery(name = "SrhEsEstado.findByAFechaModificacion", query = "SELECT s FROM SrhEsEstado s WHERE s.aFechaModificacion = :aFechaModificacion"),
    @NamedQuery(name = "SrhEsEstado.findByAUsuarioModifica", query = "SELECT s FROM SrhEsEstado s WHERE s.aUsuarioModifica = :aUsuarioModifica"),
    @NamedQuery(name = "SrhEsEstado.findByAUsuarioCrea", query = "SELECT s FROM SrhEsEstado s WHERE s.aUsuarioCrea = :aUsuarioCrea")})
public class SrhEsEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ES_ID", nullable = false)
    private Integer esId;
    @Column(name = "ES_NOMBRE", length = 100)
    private String esNombre;
    @Column(name = "A_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @Column(name = "A_FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @Column(name = "A_USUARIO_MODIFICA")
    private Integer aUsuarioModifica;
    @Column(name = "A_USUARIO_CREA")
    private Integer aUsuarioCrea;
    @OneToMany(mappedBy = "esId", fetch = FetchType.LAZY)
    private List<SrhEpEmpleado> srhEpEmpleadoList;

    public SrhEsEstado() {
    }

    public SrhEsEstado(Integer esId) {
        this.esId = esId;
    }

    public Integer getEsId() {
        return esId;
    }

    public void setEsId(Integer esId) {
        this.esId = esId;
    }

    public String getEsNombre() {
        return esNombre;
    }

    public void setEsNombre(String esNombre) {
        this.esNombre = esNombre;
    }

    public Date getAFechaCreacion() {
        return aFechaCreacion;
    }

    public void setAFechaCreacion(Date aFechaCreacion) {
        this.aFechaCreacion = aFechaCreacion;
    }

    public Date getAFechaModificacion() {
        return aFechaModificacion;
    }

    public void setAFechaModificacion(Date aFechaModificacion) {
        this.aFechaModificacion = aFechaModificacion;
    }

    public Integer getAUsuarioModifica() {
        return aUsuarioModifica;
    }

    public void setAUsuarioModifica(Integer aUsuarioModifica) {
        this.aUsuarioModifica = aUsuarioModifica;
    }

    public Integer getAUsuarioCrea() {
        return aUsuarioCrea;
    }

    public void setAUsuarioCrea(Integer aUsuarioCrea) {
        this.aUsuarioCrea = aUsuarioCrea;
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
        hash += (esId != null ? esId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrhEsEstado)) {
            return false;
        }
        SrhEsEstado other = (SrhEsEstado) object;
        if ((this.esId == null && other.esId != null) || (this.esId != null && !this.esId.equals(other.esId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.SrhEsEstado[ esId=" + esId + " ]";
    }
    
}
