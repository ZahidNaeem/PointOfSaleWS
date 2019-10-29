package org.zahid.apps.web.pos.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the XXIM_INVOICE_DTL database table.
 */
@Entity
@Table(name = "XXIM_INVOICE_DTL")
//@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
@JsonIdentityInfo(scope = InvoiceDtl.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "invDtlNum")
@NamedQueries({
    @NamedQuery(name = "InvoiceDtl.findAll", query = "SELECT i FROM InvoiceDtl i"),
    @NamedQuery(name = "InvoiceDtl.findByInvoice", query = "SELECT i FROM InvoiceDtl i where i.invoiceMain.invNum = ?1")
})
public class InvoiceDtl extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    /*@SequenceGenerator(name = "XXIM_INVOICE_DTL_INVDTLNUM_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XXIM_INVOICE_DTL_INVDTLNUM_GENERATOR")*/
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INV_DTL_NUM")
    private Long invDtlNum;

    @Column(name = "ITEM_PRICE")
    private BigDecimal itemPrice;

    private BigDecimal qnty;

    // bi-directional many-to-one association to InvoiceMain
    @ManyToOne
    @JoinColumn(name = "INV_NUM")
    private InvoiceMain invoiceMain;

    // bi-directional many-to-one association to Item
    @ManyToOne
    @JoinColumn(name = "ITEM_CODE")
    private Item item;

    public InvoiceDtl() {
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

    public InvoiceMain getInvoiceMain() {
        return invoiceMain;
    }

    public void setInvoiceMain(InvoiceMain invoiceMain) {
        this.invoiceMain = invoiceMain;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invDtlNum != null ? invDtlNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof InvoiceDtl)) {
            return false;
        }
        InvoiceDtl other = (InvoiceDtl) object;
        if ((this.invDtlNum == null && other.invDtlNum != null) || (this.invDtlNum != null && !this.invDtlNum.equals(other.invDtlNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.zahid.apps.web.pos.entity.InvoiceDtl[ invDtlNum=" + invDtlNum + " ]";
    }
}