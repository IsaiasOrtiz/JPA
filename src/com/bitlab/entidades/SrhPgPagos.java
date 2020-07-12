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
@Table(name = "SRH_PG_PAGOS", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "SrhPgPagos.findAll", query = "SELECT s FROM SrhPgPagos s"),
    @NamedQuery(name = "SrhPgPagos.findByPgId", query = "SELECT s FROM SrhPgPagos s WHERE s.pgId = :pgId"),
    @NamedQuery(name = "SrhPgPagos.findByPgFecha", query = "SELECT s FROM SrhPgPagos s WHERE s.pgFecha = :pgFecha"),
    @NamedQuery(name = "SrhPgPagos.findByPgMonto", query = "SELECT s FROM SrhPgPagos s WHERE s.pgMonto = :pgMonto"),
    @NamedQuery(name = "SrhPgPagos.findByAFechaCreacion", query = "SELECT s FROM SrhPgPagos s WHERE s.aFechaCreacion = :aFechaCreacion"),
    @NamedQuery(name = "SrhPgPagos.findByAUsuarioModifica", query = "SELECT s FROM SrhPgPagos s WHERE s.aUsuarioModifica = :aUsuarioModifica"),
    @NamedQuery(name = "SrhPgPagos.findByAFechaModificacion", query = "SELECT s FROM SrhPgPagos s WHERE s.aFechaModificacion = :aFechaModificacion"),
    @NamedQuery(name = "SrhPgPagos.findByAUsuarioCrea", query = "SELECT s FROM SrhPgPagos s WHERE s.aUsuarioCrea = :aUsuarioCrea")})
public class SrhPgPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PG_ID", nullable = false)
    private Integer pgId;
    @Column(name = "PG_FECHA")
    @Temporal(TemporalType.DATE)
    private Date pgFecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PG_MONTO", precision = 22, scale = 0)
    private Double pgMonto;
    @Column(name = "A_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @Column(name = "A_USUARIO_MODIFICA")
    private Integer aUsuarioModifica;
    @Column(name = "A_FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @Column(name = "A_USUARIO_CREA")
    private Integer aUsuarioCrea;
    @JoinColumn(name = "EP_ID", referencedColumnName = "EP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SrhEpEmpleado epId;

    public SrhPgPagos() {
    }

    public SrhPgPagos(Integer pgId) {
        this.pgId = pgId;
    }

    public Integer getPgId() {
        return pgId;
    }

    public void setPgId(Integer pgId) {
        this.pgId = pgId;
    }

    public Date getPgFecha() {
        return pgFecha;
    }

    public void setPgFecha(Date pgFecha) {
        this.pgFecha = pgFecha;
    }

    public Double getPgMonto() {
        return pgMonto;
    }

    public void setPgMonto(Double pgMonto) {
        this.pgMonto = pgMonto;
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

    public SrhEpEmpleado getEpId() {
        return epId;
    }

    public void setEpId(SrhEpEmpleado epId) {
        this.epId = epId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pgId != null ? pgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrhPgPagos)) {
            return false;
        }
        SrhPgPagos other = (SrhPgPagos) object;
        if ((this.pgId == null && other.pgId != null) || (this.pgId != null && !this.pgId.equals(other.pgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.SrhPgPagos[ pgId=" + pgId + " ]";
    }
    
}
