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
@Table(name = "SRH_SL_SALARIO", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "SrhSlSalario.findAll", query = "SELECT s FROM SrhSlSalario s"),
    @NamedQuery(name = "SrhSlSalario.findBySlId", query = "SELECT s FROM SrhSlSalario s WHERE s.slId = :slId"),
    @NamedQuery(name = "SrhSlSalario.findBySlSalario", query = "SELECT s FROM SrhSlSalario s WHERE s.slSalario = :slSalario"),
    @NamedQuery(name = "SrhSlSalario.findByAUsuarioModifica", query = "SELECT s FROM SrhSlSalario s WHERE s.aUsuarioModifica = :aUsuarioModifica"),
    @NamedQuery(name = "SrhSlSalario.findByAFechaModificacion", query = "SELECT s FROM SrhSlSalario s WHERE s.aFechaModificacion = :aFechaModificacion"),
    @NamedQuery(name = "SrhSlSalario.findByAUsuarioCrea", query = "SELECT s FROM SrhSlSalario s WHERE s.aUsuarioCrea = :aUsuarioCrea"),
    @NamedQuery(name = "SrhSlSalario.findByAFechaCreacion", query = "SELECT s FROM SrhSlSalario s WHERE s.aFechaCreacion = :aFechaCreacion")})
public class SrhSlSalario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SL_ID", nullable = false)
    private Integer slId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SL_SALARIO", precision = 22, scale = 0)
    private Double slSalario;
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
    @OneToMany(mappedBy = "slId", fetch = FetchType.LAZY)
    private List<SrhEpEmpleado> srhEpEmpleadoList;

    public SrhSlSalario() {
    }

    public SrhSlSalario(Integer slId) {
        this.slId = slId;
    }

    public Integer getSlId() {
        return slId;
    }

    public void setSlId(Integer slId) {
        this.slId = slId;
    }

    public Double getSlSalario() {
        return slSalario;
    }

    public void setSlSalario(Double slSalario) {
        this.slSalario = slSalario;
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
        hash += (slId != null ? slId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrhSlSalario)) {
            return false;
        }
        SrhSlSalario other = (SrhSlSalario) object;
        if ((this.slId == null && other.slId != null) || (this.slId != null && !this.slId.equals(other.slId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.SrhSlSalario[ slId=" + slId + " ]";
    }
    
}
