/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.sadboyz.freelo.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser")
    , @NamedQuery(name = "User.findByFacebookId", query = "SELECT u FROM User u WHERE u.facebookId = :facebookId")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUser")
    private Integer idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "facebookId")
    private String facebookId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy")
    private Collection<Work> workCollection;
    @OneToMany(mappedBy = "workedBy")
    private Collection<Work> workCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Profile> profileCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Claim> claimCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Complain> complainCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Transaction> transactionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Applications> applicationsCollection;

    public User() {
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public User(Integer idUser, String facebookId) {
        this.idUser = idUser;
        this.facebookId = facebookId;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    @XmlTransient
    public Collection<Work> getWorkCollection() {
        return workCollection;
    }

    public void setWorkCollection(Collection<Work> workCollection) {
        this.workCollection = workCollection;
    }

    @XmlTransient
    public Collection<Work> getWorkCollection1() {
        return workCollection1;
    }

    public void setWorkCollection1(Collection<Work> workCollection1) {
        this.workCollection1 = workCollection1;
    }

    @XmlTransient
    public Collection<Profile> getProfileCollection() {
        return profileCollection;
    }

    public void setProfileCollection(Collection<Profile> profileCollection) {
        this.profileCollection = profileCollection;
    }

    @XmlTransient
    public Collection<Claim> getClaimCollection() {
        return claimCollection;
    }

    public void setClaimCollection(Collection<Claim> claimCollection) {
        this.claimCollection = claimCollection;
    }

    @XmlTransient
    public Collection<Complain> getComplainCollection() {
        return complainCollection;
    }

    public void setComplainCollection(Collection<Complain> complainCollection) {
        this.complainCollection = complainCollection;
    }

    @XmlTransient
    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
    }

    @XmlTransient
    public Collection<Applications> getApplicationsCollection() {
        return applicationsCollection;
    }

    public void setApplicationsCollection(Collection<Applications> applicationsCollection) {
        this.applicationsCollection = applicationsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.sadboyz.freelo.entities.User[ idUser=" + idUser + " ]";
    }
    
}
