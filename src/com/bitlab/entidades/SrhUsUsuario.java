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
@Table(name = "SRH_US_USUARIO", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "SrhUsUsuario.findAll", query = "SELECT s FROM SrhUsUsuario s"),
    @NamedQuery(name = "SrhUsUsuario.findByUsId", query = "SELECT s FROM SrhUsUsuario s WHERE s.usId = :usId"),
    @NamedQuery(name = "SrhUsUsuario.findByUsUsuario", query = "SELECT s FROM SrhUsUsuario s WHERE s.usUsuario = :usUsuario"),
    @NamedQuery(name = "SrhUsUsuario.findByUsClave", query = "SELECT s FROM SrhUsUsuario s WHERE s.usClave = :usClave"),
    @NamedQuery(name = "SrhUsUsuario.findByAFechaModificacion", query = "SELECT s FROM SrhUsUsuario s WHERE s.aFechaModificacion = :aFechaModificacion"),
    @NamedQuery(name = "SrhUsUsuario.findByAUsuarioCrea", query = "SELECT s FROM SrhUsUsuario s WHERE s.aUsuarioCrea = :aUsuarioCrea"),
    @NamedQuery(name = "SrhUsUsuario.findByAUsuarioModifica", query = "SELECT s FROM SrhUsUsuario s WHERE s.aUsuarioModifica = :aUsuarioModifica"),
    @NamedQuery(name = "SrhUsUsuario.findByAFechaCreacion", query = "SELECT s FROM SrhUsUsuario s WHERE s.aFechaCreacion = :aFechaCreacion")})
public class SrhUsUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "US_ID", nullable = false)
    private Integer usId;
    @Column(name = "US_USUARIO", length = 100)
    private String usUsuario;
    @Basic(optional = false)
    @Column(name = "US_CLAVE", nullable = false, length = 400)
    private String usClave;
    @Column(name = "A_FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @Column(name = "A_USUARIO_CREA")
    private Integer aUsuarioCrea;
    @Column(name = "A_USUARIO_MODIFICA")
    private Integer aUsuarioModifica;
    @Column(name = "A_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @JoinColumn(name = "EP_ID", referencedColumnName = "EP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SrhEpEmpleado epId;
    @JoinColumn(name = "TP_ID", referencedColumnName = "TP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SrhTpTipo tpId;

    public SrhUsUsuario() {
    }

    public SrhUsUsuario(Integer usId) {
        this.usId = usId;
    }

    public SrhUsUsuario(Integer usId, String usClave) {
        this.usId = usId;
        this.usClave = usClave;
    }

    public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
        this.usId = usId;
    }

    public String getUsUsuario() {
        return usUsuario;
    }

    public void setUsUsuario(String usUsuario) {
        this.usUsuario = usUsuario;
    }

    public String getUsClave() {
        return usClave;
    }

    public void setUsClave(String usClave) {
        this.usClave = usClave;
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

    public Integer getAUsuarioModifica() {
        return aUsuarioModifica;
    }

    public void setAUsuarioModifica(Integer aUsuarioModifica) {
        this.aUsuarioModifica = aUsuarioModifica;
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

    public SrhTpTipo getTpId() {
        return tpId;
    }

    public void setTpId(SrhTpTipo tpId) {
        this.tpId = tpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usId != null ? usId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrhUsUsuario)) {
            return false;
        }
        SrhUsUsuario other = (SrhUsUsuario) object;
        if ((this.usId == null && other.usId != null) || (this.usId != null && !this.usId.equals(other.usId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.SrhUsUsuario[ usId=" + usId + " ]";
    }
    
}
