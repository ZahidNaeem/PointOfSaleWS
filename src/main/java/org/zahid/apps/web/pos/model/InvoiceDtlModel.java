package org.zahid.apps.web.pos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class InvoiceDtlModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long invDtlNum;

    private String createdBy;

    private Timestamp creationDate;

    private BigDecimal itemPrice;

    private Timestamp lastUpdateDate;

    private String lastUpdatedBy;

    private BigDecimal qnty;

    private Long invoiceMain;

    private Long item;

    public InvoiceDtlModel() {
    }

    public Long getInvDtlNum() {
        return invDtlNum;
    }

    public void setInvDtlNum(Long invDtlNum) {
        this.invDtlNum = invDtlNum;
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

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
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

    public BigDecimal getQnty() {
        return qnty;
    }

    public void setQnty(BigDecimal qnty) {
        this.qnty = qnty;
    }

    public Long getInvoiceMain() {
        return invoiceMain;
    }

    public void setInvoiceMain(Long invoiceMain) {
        this.invoiceMain = invoiceMain;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    public int hashCode() {
        int hash = 0;
        hash += (invDtlNum != null ? invDtlNum.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof InvoiceDtlModel)) {
            return false;
        }

        InvoiceDtlModel other = (InvoiceDtlModel) object;

        if ((this.invDtlNum == null && other.invDtlNum != null) || (this.invDtlNum != null && !this.invDtlNum.equals(other.invDtlNum))) {
            return false;

        }
        return true;

    }

    public String toString() {
        return "org.zahid.apps.web.pos.model.InvoiceDtlModel[ invDtlNum=" + invDtlNum + " ]";

    }

}
