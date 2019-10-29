package org.zahid.apps.web.pos.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the XXIM_ORGANIZATION database table.
 */
@Entity
@Table(name = "XXIM_ORGANIZATION", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ORGANIZATION_NAME"})
})
@JsonIdentityInfo(scope = Organization.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "organizationCode")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQueries({
        @NamedQuery(name = "Organization.findAll", query = "SELECT p FROM Organization p"),
        @NamedQuery(name = "Organization.generateID", query = "SELECT coalesce(max(organizationCode), 0) + 1 FROM Organization p")
})
public class Organization implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
//    @SequenceGenerator(name = "XXIM_ORGANIZATION_ORGANIZATIONCODE_GENERATOR")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XXIM_ORGANIZATION_ORGANIZATIONCODE_GENERATOR")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORGANIZATION_CODE")
    private Long organizationCode;

    @Column(name = "ORGANIZATION_NAME")
    private String organizationName;

    @Column(name = "ORGANIZATION_OWNER")
    private String organizationOwner;

    @Column(name = "CONTACT_PERSON")
    private String contactPerson;

    private String address;

    private String email;

    private String phone;

    @Column(name = "CELL_NO")
    private String cellNo;

    private String fax;

    private String web;

    // bi-directional many-to-one association to InvoiceMain
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "organization")
    private List<User> users;

   public Organization() {
    }

    public Long getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(Long organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationOwner() {
        return organizationOwner;
    }

    public void setOrganizationOwner(String organizationOwner) {
        this.organizationOwner = organizationOwner;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (organizationCode != null ? organizationCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Organization)) {
            return false;
        }
        Organization other = (Organization) object;
        if ((this.organizationCode == null && other.organizationCode != null) || (this.organizationCode != null && !this.organizationCode.equals(other.organizationCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.zahid.apps.web.pos.entity.Organization[ organizationCode=" + organizationCode + " ]";
    }
}