/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.sadboyz.freelo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "applications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Applications.findAll", query = "SELECT a FROM Applications a")
    , @NamedQuery(name = "Applications.findByIdApplication", query = "SELECT a FROM Applications a WHERE a.idApplication = :idApplication")
    , @NamedQuery(name = "Applications.findByDate", query = "SELECT a FROM Applications a WHERE a.date = :date")})
public class Applications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idApplication")
    private Integer idApplication;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "idWork", referencedColumnName = "idWork")
    @ManyToOne(optional = false)
    private Work idWork;

    public Applications() {
    }

    public Applications(Integer idApplication) {
        this.idApplication = idApplication;
    }

    public Applications(Integer idApplication, Date date) {
        this.idApplication = idApplication;
        this.date = date;
    }

    public Integer getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(Integer idApplication) {
        this.idApplication = idApplication;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Work getIdWork() {
        return idWork;
    }

    public void setIdWork(Work idWork) {
        this.idWork = idWork;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApplication != null ? idApplication.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Applications)) {
            return false;
        }
        Applications other = (Applications) object;
        if ((this.idApplication == null && other.idApplication != null) || (this.idApplication != null && !this.idApplication.equals(other.idApplication))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.sadboyz.freelo.entities.Applications[ idApplication=" + idApplication + " ]";
    }
    
}
