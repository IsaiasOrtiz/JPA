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
@Table(name = "SRH_SX_SEXO", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "SrhSxSexo.findAll", query = "SELECT s FROM SrhSxSexo s"),
    @NamedQuery(name = "SrhSxSexo.findBySxId", query = "SELECT s FROM SrhSxSexo s WHERE s.sxId = :sxId"),
    @NamedQuery(name = "SrhSxSexo.findBySxNombre", query = "SELECT s FROM SrhSxSexo s WHERE s.sxNombre = :sxNombre"),
    @NamedQuery(name = "SrhSxSexo.findByAUsuarioModifica", query = "SELECT s FROM SrhSxSexo s WHERE s.aUsuarioModifica = :aUsuarioModifica"),
    @NamedQuery(name = "SrhSxSexo.findByAFechaModificacion", query = "SELECT s FROM SrhSxSexo s WHERE s.aFechaModificacion = :aFechaModificacion"),
    @NamedQuery(name = "SrhSxSexo.findByAUsuarioCrea", query = "SELECT s FROM SrhSxSexo s WHERE s.aUsuarioCrea = :aUsuarioCrea"),
    @NamedQuery(name = "SrhSxSexo.findByAFechaCreacion", query = "SELECT s FROM SrhSxSexo s WHERE s.aFechaCreacion = :aFechaCreacion")})
public class SrhSxSexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SX_ID", nullable = false)
    private Integer sxId;
    @Column(name = "SX_NOMBRE", length = 20)
    private String sxNombre;
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
    @OneToMany(mappedBy = "sxId", fetch = FetchType.LAZY)
    private List<SrhEpEmpleado> srhEpEmpleadoList;

    public SrhSxSexo() {
    }

    public SrhSxSexo(Integer sxId) {
        this.sxId = sxId;
    }

    public Integer getSxId() {
        return sxId;
    }

    public void setSxId(Integer sxId) {
        this.sxId = sxId;
    }

    public String getSxNombre() {
        return sxNombre;
    }

    public void setSxNombre(String sxNombre) {
        this.sxNombre = sxNombre;
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
        hash += (sxId != null ? sxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrhSxSexo)) {
            return false;
        }
        SrhSxSexo other = (SrhSxSexo) object;
        if ((this.sxId == null && other.sxId != null) || (this.sxId != null && !this.sxId.equals(other.sxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.SrhSxSexo[ sxId=" + sxId + " ]";
    }
    
}
