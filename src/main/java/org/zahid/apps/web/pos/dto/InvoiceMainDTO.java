package org.zahid.apps.web.pos.dto;

import org.zahid.apps.web.pos.entity.InvoiceDtl;
import org.zahid.apps.web.pos.entity.InvoiceMain;
import org.zahid.apps.web.pos.entity.NavigationDtl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class InvoiceMainDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private NavigationDtl navigationDtl;

    private Long invNum;

    private Date invDate;

    private String invType;

    private BigDecimal paidAmt;

    private String reason;

    private String remarks;

    private Long refInvoice;

    private List<InvoiceMain> invoiceMains;

    private String createdBy;

    private Timestamp creationDate;

    private String lastUpdatedBy;

    private Timestamp lastUpdateDate;

    private List<InvoiceDtl> invoiceDtls;

    private Long party;

    public NavigationDtl getNavigationDtl() {
        return navigationDtl;
    }

    public void setNavigationDtl(NavigationDtl navigationDtl) {
        this.navigationDtl = navigationDtl;
    }

    public Long getInvNum() {
        return invNum;
    }

    public void setInvNum(Long invNum) {
        this.invNum = invNum;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public String getInvType() {
        return invType;
    }

    public void setInvType(String invType) {
        this.invType = invType;
    }

    public BigDecimal getPaidAmt() {
        return paidAmt;
    }

    public void setPaidAmt(BigDecimal paidAmt) {
        this.paidAmt = paidAmt;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getRefInvoice() {
        return refInvoice;
    }

    public void setRefInvoice(Long refInvoice) {
        this.refInvoice = refInvoice;
    }

    public List<InvoiceMain> getInvoiceMains() {
        return invoiceMains;
    }

    public void setInvoiceMains(List<InvoiceMain> invoiceMains) {
        this.invoiceMains = invoiceMains;
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

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public List<InvoiceDtl> getInvoiceDtls() {
        return invoiceDtls;
    }

    public void setInvoiceDtls(List<InvoiceDtl> invoiceDtls) {
        this.invoiceDtls = invoiceDtls;
    }

    public Long getParty() {
        return party;
    }

    public void setParty(Long party) {
        this.party = party;
    }
}
