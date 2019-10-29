package org.zahid.apps.web.pos.model;

import org.zahid.apps.web.pos.entity.Auditable;
import org.zahid.apps.web.pos.entity.AuditorDetail;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class InvoiceDtlModel extends Auditable<AuditorDetail> implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long invDtlNum;

    private BigDecimal itemPrice;

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

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
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
