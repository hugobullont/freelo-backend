/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.sadboyz.freelo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "work")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Work.findAll", query = "SELECT w FROM Work w")
    , @NamedQuery(name = "Work.findByIdWork", query = "SELECT w FROM Work w WHERE w.idWork = :idWork")
    , @NamedQuery(name = "Work.findByStatus", query = "SELECT w FROM Work w WHERE w.status = :status")
    , @NamedQuery(name = "Work.findByName", query = "SELECT w FROM Work w WHERE w.name = :name")
    , @NamedQuery(name = "Work.findByDescription", query = "SELECT w FROM Work w WHERE w.description = :description")
    , @NamedQuery(name = "Work.findByBasePrice", query = "SELECT w FROM Work w WHERE w.basePrice = :basePrice")
    , @NamedQuery(name = "Work.findByPubPrice", query = "SELECT w FROM Work w WHERE w.pubPrice = :pubPrice")
    , @NamedQuery(name = "Work.findByDate", query = "SELECT w FROM Work w WHERE w.date = :date")})
public class Work implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idWork")
    private Integer idWork;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "basePrice")
    private BigDecimal basePrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pubPrice")
    private BigDecimal pubPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User createdBy;
    @JoinColumn(name = "idTransaction", referencedColumnName = "idTransaction")
    @ManyToOne
    private Transaction idTransaction;
    @JoinColumn(name = "WorkedBy", referencedColumnName = "idUser")
    @ManyToOne
    private User workedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idWork")
    private Collection<Complain> complainCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idWork")
    private Collection<Applications> applicationsCollection;

    public Work() {
    }

    public Work(Integer idWork) {
        this.idWork = idWork;
    }

    public Work(Integer idWork, String status, String name, String description, BigDecimal basePrice, BigDecimal pubPrice, Date date) {
        this.idWork = idWork;
        this.status = status;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.pubPrice = pubPrice;
        this.date = date;
    }

    public Integer getIdWork() {
        return idWork;
    }

    public void setIdWork(Integer idWork) {
        this.idWork = idWork;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getPubPrice() {
        return pubPrice;
    }

    public void setPubPrice(BigDecimal pubPrice) {
        this.pubPrice = pubPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Transaction getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Transaction idTransaction) {
        this.idTransaction = idTransaction;
    }

    public User getWorkedBy() {
        return workedBy;
    }

    public void setWorkedBy(User workedBy) {
        this.workedBy = workedBy;
    }

    @XmlTransient
    public Collection<Complain> getComplainCollection() {
        return complainCollection;
    }

    public void setComplainCollection(Collection<Complain> complainCollection) {
        this.complainCollection = complainCollection;
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
        hash += (idWork != null ? idWork.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Work)) {
            return false;
        }
        Work other = (Work) object;
        if ((this.idWork == null && other.idWork != null) || (this.idWork != null && !this.idWork.equals(other.idWork))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.sadboyz.freelo.entities.Work[ idWork=" + idWork + " ]";
    }
    
}
