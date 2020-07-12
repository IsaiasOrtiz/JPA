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
@Table(name = "SRH_EP_EMPLEADO", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "SrhEpEmpleado.findAll", query = "SELECT s FROM SrhEpEmpleado s"),
    @NamedQuery(name = "SrhEpEmpleado.findByEpId", query = "SELECT s FROM SrhEpEmpleado s WHERE s.epId = :epId"),
    @NamedQuery(name = "SrhEpEmpleado.findByEpNombres", query = "SELECT s FROM SrhEpEmpleado s WHERE s.epNombres = :epNombres"),
    @NamedQuery(name = "SrhEpEmpleado.findByEpApellidos", query = "SELECT s FROM SrhEpEmpleado s WHERE s.epApellidos = :epApellidos"),
    @NamedQuery(name = "SrhEpEmpleado.findByEpDireccion", query = "SELECT s FROM SrhEpEmpleado s WHERE s.epDireccion = :epDireccion"),
    @NamedQuery(name = "SrhEpEmpleado.findByEpFechaNacimiento", query = "SELECT s FROM SrhEpEmpleado s WHERE s.epFechaNacimiento = :epFechaNacimiento"),
    @NamedQuery(name = "SrhEpEmpleado.findByEpDui", query = "SELECT s FROM SrhEpEmpleado s WHERE s.epDui = :epDui"),
    @NamedQuery(name = "SrhEpEmpleado.findByAUsuarioModifica", query = "SELECT s FROM SrhEpEmpleado s WHERE s.aUsuarioModifica = :aUsuarioModifica"),
    @NamedQuery(name = "SrhEpEmpleado.findByAUsuarioCrea", query = "SELECT s FROM SrhEpEmpleado s WHERE s.aUsuarioCrea = :aUsuarioCrea"),
    @NamedQuery(name = "SrhEpEmpleado.findByAFechaCreacion", query = "SELECT s FROM SrhEpEmpleado s WHERE s.aFechaCreacion = :aFechaCreacion"),
    @NamedQuery(name = "SrhEpEmpleado.findByAFechaModificacion", query = "SELECT s FROM SrhEpEmpleado s WHERE s.aFechaModificacion = :aFechaModificacion")})
public class SrhEpEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EP_ID", nullable = false)
    private Integer epId;
    @Column(name = "EP_NOMBRES", length = 200)
    private String epNombres;
    @Basic(optional = false)
    @Column(name = "EP_APELLIDOS", nullable = false, length = 200)
    private String epApellidos;
    @Basic(optional = false)
    @Column(name = "EP_DIRECCION", nullable = false, length = 500)
    private String epDireccion;
    @Column(name = "EP_FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date epFechaNacimiento;
    @Basic(optional = false)
    @Column(name = "EP_DUI", nullable = false, length = 20)
    private String epDui;
    @Column(name = "A_USUARIO_MODIFICA")
    private Integer aUsuarioModifica;
    @Column(name = "A_USUARIO_CREA")
    private Integer aUsuarioCrea;
    @Column(name = "A_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaCreacion;
    @Column(name = "A_FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date aFechaModificacion;
    @OneToMany(mappedBy = "epId", fetch = FetchType.LAZY)
    private List<SrhHtpHistorialEmpleado> srhHtpHistorialEmpleadoList;
    @OneToMany(mappedBy = "epId", fetch = FetchType.LAZY)
    private List<SrhUsUsuario> srhUsUsuarioList;
    @OneToMany(mappedBy = "epId", fetch = FetchType.LAZY)
    private List<SrhPgPagos> srhPgPagosList;
    @JoinColumn(name = "DP_ID", referencedColumnName = "DP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SrhDpArea dpId;
    @JoinColumn(name = "EC_ID", referencedColumnName = "EC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SrhEcEstadoCivil ecId;
    @JoinColumn(name = "ES_ID", referencedColumnName = "ES_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SrhEsEstado esId;
    @JoinColumn(name = "SL_ID", referencedColumnName = "SL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SrhSlSalario slId;
    @JoinColumn(name = "SX_ID", referencedColumnName = "SX_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SrhSxSexo sxId;

    public SrhEpEmpleado() {
    }

    public SrhEpEmpleado(Integer epId) {
        this.epId = epId;
    }

    public SrhEpEmpleado(Integer epId, String epApellidos, String epDireccion, String epDui) {
        this.epId = epId;
        this.epApellidos = epApellidos;
        this.epDireccion = epDireccion;
        this.epDui = epDui;
    }

    public Integer getEpId() {
        return epId;
    }

    public void setEpId(Integer epId) {
        this.epId = epId;
    }

    public String getEpNombres() {
        return epNombres;
    }

    public void setEpNombres(String epNombres) {
        this.epNombres = epNombres;
    }

    public String getEpApellidos() {
        return epApellidos;
    }

    public void setEpApellidos(String epApellidos) {
        this.epApellidos = epApellidos;
    }

    public String getEpDireccion() {
        return epDireccion;
    }

    public void setEpDireccion(String epDireccion) {
        this.epDireccion = epDireccion;
    }

    public Date getEpFechaNacimiento() {
        return epFechaNacimiento;
    }

    public void setEpFechaNacimiento(Date epFechaNacimiento) {
        this.epFechaNacimiento = epFechaNacimiento;
    }

    public String getEpDui() {
        return epDui;
    }

    public void setEpDui(String epDui) {
        this.epDui = epDui;
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

    public List<SrhHtpHistorialEmpleado> getSrhHtpHistorialEmpleadoList() {
        return srhHtpHistorialEmpleadoList;
    }

    public void setSrhHtpHistorialEmpleadoList(List<SrhHtpHistorialEmpleado> srhHtpHistorialEmpleadoList) {
        this.srhHtpHistorialEmpleadoList = srhHtpHistorialEmpleadoList;
    }

    public List<SrhUsUsuario> getSrhUsUsuarioList() {
        return srhUsUsuarioList;
    }

    public void setSrhUsUsuarioList(List<SrhUsUsuario> srhUsUsuarioList) {
        this.srhUsUsuarioList = srhUsUsuarioList;
    }

    public List<SrhPgPagos> getSrhPgPagosList() {
        return srhPgPagosList;
    }

    public void setSrhPgPagosList(List<SrhPgPagos> srhPgPagosList) {
        this.srhPgPagosList = srhPgPagosList;
    }

    public SrhDpArea getDpId() {
        return dpId;
    }

    public void setDpId(SrhDpArea dpId) {
        this.dpId = dpId;
    }

    public SrhEcEstadoCivil getEcId() {
        return ecId;
    }

    public void setEcId(SrhEcEstadoCivil ecId) {
        this.ecId = ecId;
    }

    public SrhEsEstado getEsId() {
        return esId;
    }

    public void setEsId(SrhEsEstado esId) {
        this.esId = esId;
    }

    public SrhSlSalario getSlId() {
        return slId;
    }

    public void setSlId(SrhSlSalario slId) {
        this.slId = slId;
    }

    public SrhSxSexo getSxId() {
        return sxId;
    }

    public void setSxId(SrhSxSexo sxId) {
        this.sxId = sxId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (epId != null ? epId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrhEpEmpleado)) {
            return false;
        }
        SrhEpEmpleado other = (SrhEpEmpleado) object;
        if ((this.epId == null && other.epId != null) || (this.epId != null && !this.epId.equals(other.epId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.SrhEpEmpleado[ epId=" + epId + " ]";
    }
    
}
