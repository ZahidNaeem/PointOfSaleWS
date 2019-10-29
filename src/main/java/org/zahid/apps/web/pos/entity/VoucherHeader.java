package org.zahid.apps.web.pos.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the XXIM_VOUCHER_HEADER database table.
 */
@Entity
@Table(name = "XXIM_VOUCHER_HEADER")
@JsonIdentityInfo(scope = VoucherHeader.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "headerId")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQuery(name = "VoucherHeader.findAll", query = "SELECT v FROM VoucherHeader v")
public class VoucherHeader extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    /*@SequenceGenerator(name = "XXIM_VOUCHER_HEADER_HEADERID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XXIM_VOUCHER_HEADER_HEADERID_GENERATOR")*/
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HEADER_ID")
    private Long headerId;

    private String remarks;

    @Temporal(TemporalType.DATE)
    @Column(name = "VOUCHER_DATE")
    private Date voucherDate;

    @Column(name = "VOUCHER_TYPE")
    private String voucherType;

    // bi-directional many-to-one association to Party
    @ManyToOne
    @JoinColumn(name = "PARTY_CODE")
    private Party party;

    // bi-directional many-to-one association to VoucherLine
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "voucherHeader")
    private List<VoucherLine> voucherLines;

    public VoucherHeader() {
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(Date voucherDate) {
        this.voucherDate = voucherDate;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public List<VoucherLine> getVoucherLines() {
        return voucherLines;
    }

    public void setVoucherLines(List<VoucherLine> voucherLines) {
        this.voucherLines = voucherLines;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (headerId != null ? headerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof VoucherHeader)) {
            return false;
        }
        VoucherHeader other = (VoucherHeader) object;
        if ((this.headerId == null && other.headerId != null) || (this.headerId != null && !this.headerId.equals(other.headerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.zahid.apps.web.pos.entity.VoucherHeader[ headerId=" + headerId + " ]";
    }
}