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
@Table(name = "claim")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Claim.findAll", query = "SELECT c FROM Claim c")
    , @NamedQuery(name = "Claim.findByIdClaim", query = "SELECT c FROM Claim c WHERE c.idClaim = :idClaim")
    , @NamedQuery(name = "Claim.findByDate", query = "SELECT c FROM Claim c WHERE c.date = :date")})
public class Claim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClaim")
    private Integer idClaim;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "idReward", referencedColumnName = "idReward")
    @ManyToOne(optional = false)
    private Reward idReward;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idUser;

    public Claim() {
    }

    public Claim(Integer idClaim) {
        this.idClaim = idClaim;
    }

    public Claim(Integer idClaim, Date date) {
        this.idClaim = idClaim;
        this.date = date;
    }

    public Integer getIdClaim() {
        return idClaim;
    }

    public void setIdClaim(Integer idClaim) {
        this.idClaim = idClaim;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Reward getIdReward() {
        return idReward;
    }

    public void setIdReward(Reward idReward) {
        this.idReward = idReward;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClaim != null ? idClaim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Claim)) {
            return false;
        }
        Claim other = (Claim) object;
        if ((this.idClaim == null && other.idClaim != null) || (this.idClaim != null && !this.idClaim.equals(other.idClaim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.sadboyz.freelo.entities.Claim[ idClaim=" + idClaim + " ]";
    }
    
}
