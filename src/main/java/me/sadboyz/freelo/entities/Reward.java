/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.sadboyz.freelo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "reward")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reward.findAll", query = "SELECT r FROM Reward r")
    , @NamedQuery(name = "Reward.findByIdReward", query = "SELECT r FROM Reward r WHERE r.idReward = :idReward")
    , @NamedQuery(name = "Reward.findByName", query = "SELECT r FROM Reward r WHERE r.name = :name")
    , @NamedQuery(name = "Reward.findByDescription", query = "SELECT r FROM Reward r WHERE r.description = :description")
    , @NamedQuery(name = "Reward.findByPrice", query = "SELECT r FROM Reward r WHERE r.price = :price")
    , @NamedQuery(name = "Reward.findByQuantity", query = "SELECT r FROM Reward r WHERE r.quantity = :quantity")
    , @NamedQuery(name = "Reward.findByStatus", query = "SELECT r FROM Reward r WHERE r.status = :status")})
public class Reward implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReward")
    private Integer idReward;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReward")
    private Collection<Claim> claimCollection;

    public Reward() {
    }

    public Reward(Integer idReward) {
        this.idReward = idReward;
    }

    public Reward(Integer idReward, String name, String description, BigDecimal price, int quantity, boolean status) {
        this.idReward = idReward;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public Integer getIdReward() {
        return idReward;
    }

    public void setIdReward(Integer idReward) {
        this.idReward = idReward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Claim> getClaimCollection() {
        return claimCollection;
    }

    public void setClaimCollection(Collection<Claim> claimCollection) {
        this.claimCollection = claimCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReward != null ? idReward.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reward)) {
            return false;
        }
        Reward other = (Reward) object;
        if ((this.idReward == null && other.idReward != null) || (this.idReward != null && !this.idReward.equals(other.idReward))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.sadboyz.freelo.entities.Reward[ idReward=" + idReward + " ]";
    }
    
}
