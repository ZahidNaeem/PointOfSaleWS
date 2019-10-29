package org.zahid.apps.web.pos.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the XXIM_PARTIES database table.
 */
@Entity
@Table(name = "XXIM_PARTIES", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"PARTY_NAME"})
})
@JsonIdentityInfo(scope = Party.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "partyCode")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQueries({
        @NamedQuery(name = "Party.findAll", query = "SELECT p FROM Party p"),
        @NamedQuery(name = "Party.generateID", query = "SELECT coalesce(max(partyCode), 0) + 1 FROM Party p")
})
public class Party extends Auditable<User> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
//    @SequenceGenerator(name = "XXIM_PARTIES_PARTYCODE_GENERATOR")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XXIM_PARTIES_PARTYCODE_GENERATOR")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PARTY_CODE")
    private Long partyCode;

    private String address;

    @Column(name = "CELL_NO")
    private String cellNo;

    @Column(name = "CONTACT_PERSON")
    private String contactPerson;

    @Temporal(TemporalType.DATE)
    @Column(name = "EFFECTIVE_END_DATE")
    private Date effectiveEndDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "EFFECTIVE_START_DATE")
    private Date effectiveStartDate;

    private String email;

    private String fax;

    private String ntn;

    @Column(name = "PARTY_NAME")
    private String partyName;

    @Column(name = "PARTY_OWNER")
    private String partyOwner;

    @Column(name = "PARTY_TYPE")
    private String partyType;

    private String phone;

    private String strn;

    private String web;

    // bi-directional many-to-one association to InvoiceMain
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "party")
    private List<InvoiceMain> invoiceMains;

    // bi-directional many-to-one association to PartyBalance
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "party")
    private List<PartyBalance> partyBalances;

    // bi-directional many-to-one association to VoucherHeader
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "party")
    private List<VoucherHeader> voucherHeaders;

    public Party() {
    }

    public Long getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(Long partyCode) {
        this.partyCode = partyCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Date getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    public Date getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(Date effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNtn() {
        return ntn;
    }

    public void setNtn(String ntn) {
        this.ntn = ntn;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyOwner() {
        return partyOwner;
    }

    public void setPartyOwner(String partyOwner) {
        this.partyOwner = partyOwner;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStrn() {
        return strn;
    }

    public void setStrn(String strn) {
        this.strn = strn;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public List<InvoiceMain> getInvoiceMains() {
        return invoiceMains;
    }

    public void setInvoiceMains(List<InvoiceMain> invoiceMains) {
        this.invoiceMains = invoiceMains;
    }

    public List<PartyBalance> getPartyBalances() {
        return partyBalances;
    }

    public void setPartyBalances(List<PartyBalance> partyBalances) {
        this.partyBalances = partyBalances;
    }

    public List<VoucherHeader> getVoucherHeaders() {
        return voucherHeaders;
    }

    public void setVoucherHeaders(List<VoucherHeader> voucherHeaders) {
        this.voucherHeaders = voucherHeaders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partyCode != null ? partyCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Party)) {
            return false;
        }
        Party other = (Party) object;
        if ((this.partyCode == null && other.partyCode != null) || (this.partyCode != null && !this.partyCode.equals(other.partyCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.zahid.apps.web.pos.entity.Party[ partyCode=" + partyCode + " ]";
    }
}