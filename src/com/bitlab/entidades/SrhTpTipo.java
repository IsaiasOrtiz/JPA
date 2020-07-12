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
@Table(name = "SRH_TP_TIPO", catalog = "DB_SISTEMA_RRHH", schema = "")
@NamedQueries({
    @NamedQuery(name = "SrhTpTipo.findAll", query = "SELECT s FROM SrhTpTipo s"),
    @NamedQuery(name = "SrhTpTipo.findByTpId", query = "SELECT s FROM SrhTpTipo s WHERE s.tpId = :tpId"),
    @NamedQuery(name = "SrhTpTipo.findByTpNombre", query = "SELECT s FROM SrhTpTipo s WHERE s.tpNombre = :tpNombre"),
    @NamedQuery(name = "SrhTpTipo.findByAUsuarioModifica", query = "SELECT s FROM SrhTpTipo s WHERE s.aUsuarioModifica = :aUsuarioModifica"),
    @NamedQuery(name = "SrhTpTipo.findByAUsuarioCrea", query = "SELECT s FROM SrhTpTipo s WHERE s.aUsuarioCrea = :aUsuarioCrea"),
    @NamedQuery(name = "SrhTpTipo.findByAFechaModificacion", query = "SELECT s FROM SrhTpTipo s WHERE s.aFechaModificacion = :aFechaModificacion"),
    @NamedQuery(name = "SrhTpTipo.findByAFechaCreacion", query = "SELECT s FROM SrhTpTipo s WHERE s.aFechaCreacion = :aFechaCreacion")})
public class SrhTpTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TP_ID", nullable = false)
    private Integer tpId;
    @Column(name = "TP_NOMBRE", length = 20)
    private String tpNombre;
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
    @OneToMany(mappedBy = "tpId", fetch = FetchType.LAZY)
    private List<SrhUsUsuario> srhUsUsuarioList;

    public SrhTpTipo() {
    }

    public SrhTpTipo(Integer tpId) {
        this.tpId = tpId;
    }

    public Integer getTpId() {
        return tpId;
    }

    public void setTpId(Integer tpId) {
        this.tpId = tpId;
    }

    public String getTpNombre() {
        return tpNombre;
    }

    public void setTpNombre(String tpNombre) {
        this.tpNombre = tpNombre;
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

    public List<SrhUsUsuario> getSrhUsUsuarioList() {
        return srhUsUsuarioList;
    }

    public void setSrhUsUsuarioList(List<SrhUsUsuario> srhUsUsuarioList) {
        this.srhUsUsuarioList = srhUsUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpId != null ? tpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SrhTpTipo)) {
            return false;
        }
        SrhTpTipo other = (SrhTpTipo) object;
        if ((this.tpId == null && other.tpId != null) || (this.tpId != null && !this.tpId.equals(other.tpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitlab.entidades.SrhTpTipo[ tpId=" + tpId + " ]";
    }
    
}
