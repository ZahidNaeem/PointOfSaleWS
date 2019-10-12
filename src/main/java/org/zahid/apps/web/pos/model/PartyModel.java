package org.zahid.apps.web.pos.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.zahid.apps.web.pos.entity.VoucherHeader;

public class PartyModel implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long partyCode;
  private String address;
  private String cellNo;
  private String contactPerson;
  private String createdBy;
  private Timestamp creationDate;
  private Date effectiveEndDate;
  private Date effectiveStartDate;
  private String email;
  private String fax;
  private Timestamp lastUpdateDate;
  private String lastUpdatedBy;
  private String ntn;
  private String partyName;
  private String partyOwner;
  private String partyType;
  private String phone;
  private String strn;
  private String web;
  private List<InvoiceMainModel> invoiceMains;
  private List<PartyBalanceModel> partyBalances;
  private List<VoucherHeader> voucherHeaders;

  public PartyModel() {
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

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
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

  public Timestamp getLastUpdateDate() {
    return lastUpdateDate;
  }

  public void setLastUpdateDate(Timestamp lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  public String getLastUpdatedBy() {
    return lastUpdatedBy;
  }

  public void setLastUpdatedBy(String lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
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

  public List<InvoiceMainModel> getInvoiceMains() {
    return invoiceMains;
  }

  public void setInvoiceMains(List<InvoiceMainModel> invoiceMains) {
    this.invoiceMains = invoiceMains;
  }

  public List<PartyBalanceModel> getPartyBalances() {
    return partyBalances;
  }

  public void setPartyBalances(List<PartyBalanceModel> partyBalances) {
    this.partyBalances = partyBalances;
  }

  public List<VoucherHeader> getVoucherHeaders() {
    return voucherHeaders;
  }

  public void setVoucherHeaders(List<VoucherHeader> voucherHeaders) {
    this.voucherHeaders = voucherHeaders;
  }

  public int hashCode() {
    int hash = 0;
    hash += (partyCode != null ? partyCode.hashCode() : 0);
    return hash;
  }

  public boolean equals(Object object) {
    if (!(object instanceof PartyModel)) {
      return false;
    }
    PartyModel other = (PartyModel) object;
    if ((this.partyCode == null && other.partyCode != null) || (this.partyCode != null
        && !this.partyCode.equals(other.partyCode))) {
      return false;
    }
    return true;
  }

  public String toString() {
    return "org.zahid.apps.web.pos.entity.PartyModel[ partyCode=" + partyCode + " ]";
  }
}
