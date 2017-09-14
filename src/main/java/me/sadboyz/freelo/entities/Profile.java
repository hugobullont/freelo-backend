/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.sadboyz.freelo.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p")
    , @NamedQuery(name = "Profile.findByIdProfile", query = "SELECT p FROM Profile p WHERE p.idProfile = :idProfile")
    , @NamedQuery(name = "Profile.findByName", query = "SELECT p FROM Profile p WHERE p.name = :name")
    , @NamedQuery(name = "Profile.findByLastName", query = "SELECT p FROM Profile p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "Profile.findByEmail", query = "SELECT p FROM Profile p WHERE p.email = :email")
    , @NamedQuery(name = "Profile.findByDescription", query = "SELECT p FROM Profile p WHERE p.description = :description")
    , @NamedQuery(name = "Profile.findByPhoneNumber", query = "SELECT p FROM Profile p WHERE p.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Profile.findByRating", query = "SELECT p FROM Profile p WHERE p.rating = :rating")
    , @NamedQuery(name = "Profile.findByBank", query = "SELECT p FROM Profile p WHERE p.bank = :bank")
    , @NamedQuery(name = "Profile.findByBankAccount", query = "SELECT p FROM Profile p WHERE p.bankAccount = :bankAccount")
    , @NamedQuery(name = "Profile.findByCredit", query = "SELECT p FROM Profile p WHERE p.credit = :credit")})
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfile")
    private Integer idProfile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastName")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "phoneNumber")
    private int phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rating")
    private int rating;
    @Size(max = 50)
    @Column(name = "bank")
    private String bank;
    @Size(max = 120)
    @Column(name = "bankAccount")
    private String bankAccount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credit")
    private int credit;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idUser;

    public Profile() {
    }

    public Profile(Integer idProfile) {
        this.idProfile = idProfile;
    }

    public Profile(Integer idProfile, String name, String lastName, String email, String description, int phoneNumber, int rating, int credit) {
        this.idProfile = idProfile;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.credit = credit;
    }

    public Integer getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Integer idProfile) {
        this.idProfile = idProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
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
        hash += (idProfile != null ? idProfile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.idProfile == null && other.idProfile != null) || (this.idProfile != null && !this.idProfile.equals(other.idProfile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.sadboyz.freelo.entities.Profile[ idProfile=" + idProfile + " ]";
    }
    
}
