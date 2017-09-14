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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "complain")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complain.findAll", query = "SELECT c FROM Complain c")
    , @NamedQuery(name = "Complain.findByIdComplain", query = "SELECT c FROM Complain c WHERE c.idComplain = :idComplain")
    , @NamedQuery(name = "Complain.findByDate", query = "SELECT c FROM Complain c WHERE c.date = :date")
    , @NamedQuery(name = "Complain.findByDescription", query = "SELECT c FROM Complain c WHERE c.description = :description")})
public class Complain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComplain")
    private Integer idComplain;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "idWork", referencedColumnName = "idWork")
    @ManyToOne(optional = false)
    private Work idWork;

    public Complain() {
    }

    public Complain(Integer idComplain) {
        this.idComplain = idComplain;
    }

    public Complain(Integer idComplain, Date date, String description) {
        this.idComplain = idComplain;
        this.date = date;
        this.description = description;
    }

    public Integer getIdComplain() {
        return idComplain;
    }

    public void setIdComplain(Integer idComplain) {
        this.idComplain = idComplain;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (idComplain != null ? idComplain.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complain)) {
            return false;
        }
        Complain other = (Complain) object;
        if ((this.idComplain == null && other.idComplain != null) || (this.idComplain != null && !this.idComplain.equals(other.idComplain))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.sadboyz.freelo.entities.Complain[ idComplain=" + idComplain + " ]";
    }
    
}
