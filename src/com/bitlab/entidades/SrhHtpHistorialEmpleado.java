/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
@Entity
@Table(name = "SRH_HTP_HISTORIAL_EMPLEADO", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "SrhHtpHistorialEmpleado.findAll", query = "SELECT s FROM SrhHtpHistorialEmpleado s"),
    @NamedQuery(name = "SrhHtpHistorialEmpleado.findByHtpId", query = "SELECT s FROM SrhHtpHistorialEmpleado s WHERE s.htpId = :htpId"),
    @NamedQuery(name = "SrhHtpHistorialEmpleado.findByHtpDescripcion", query = "SELECT s FROM SrhHtpHistorialEmpleado s WHERE s.htpDescripcion = :htpDescripcion"),
    @NamedQuery(name = "SrhHtpHistorialEmpleado.findByAUsuarioModifica", query = "SELECT s FROM SrhHtpHistorialEmpleado s WHERE s.aUsuarioModifica = :aUsuarioModifica"),
    @NamedQuery(name = "SrhHtpHistorialEmpleado.findByAUsuarioCrea", query = "SELECT s FROM SrhHtpHistorialEmpleado s WHERE s.aUsuarioCrea = :aUsuarioCrea"),
    @NamedQuery(name = "SrhHtpHistorialEmpleado.findByAFechaModificacion", query = "SELECT s FROM SrhHtpHistorialEmpleado s WHERE s.aFechaModificacion = :aFechaModificacion"),
    @NamedQuery(name = "SrhHtpHistorialEmpleado.findByAFechaCreacion", query = "SELECT s FROM SrhHtpHistorialEmpleado s WHERE s.aFechaCreacion = :aFechaCreacion")})
public class SrhHtpHistorialEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HTP_ID", nullable = false)
    private Integer htpId;
    @Column(name = "HTP_DESCRIPCION", length = 500)
    private String htpDescripcion;
    @Column(name = "A_USUARIO_MODIFICA")
    private Integer aUsuarioModifica;
    @Column(name = "A_USUARIO_CREA")
    private Integer aUsuarioCrea;
    @Column(name = "A_FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @Column(name = "A_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @JoinColumn(name = "EP_ID", referencedColumnName = "EP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SrhEpEmpleado epId;

    public SrhHtpHistorialEmpleado() {
    }

    public SrhHtpHistorialEmpleado(Integer htpId) {
        this.htpId = htpId;
    }

    public Integer getHtpId() {
        return htpId;
    }

    public void setHtpId(Integer htpId) {
        this.htpId = htpId;
    }

    public String getHtpDescripcion() {
        return htpDescripcion;
    }

    public void setHtpDescripcion(String htpDescripcion) {
        this.htpDescripcion = htpDescripcion;
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

    public SrhEpEmpleado getEpId() {
        return epId;
    }

    public void setEpId(SrhEpEmpleado epId) {
        this.epId = epId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (htpId != null ? htpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrhHtpHistorialEmpleado)) {
            return false;
        }
        SrhHtpHistorialEmpleado other = (SrhHtpHistorialEmpleado) object;
        if ((this.htpId == null && other.htpId != null) || (this.htpId != null && !this.htpId.equals(other.htpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.SrhHtpHistorialEmpleado[ htpId=" + htpId + " ]";
    }
    
}
