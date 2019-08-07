package org.zahid.apps.web.pos.dto;

import org.zahid.apps.web.pos.entity.Party;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class PartyBalanceDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long partyBalanceId;

    private BigDecimal amount;

    private String createdBy;

    private Timestamp creationDate;

    private Timestamp lastUpdateDate;

    private String lastUpdatedBy;

    private Date partyBalanceDate;

    private String remarks;

    private Long party;

    public Long getPartyBalanceId() {
        return partyBalanceId;
    }

    public void setPartyBalanceId(Long partyBalanceId) {
        this.partyBalanceId = partyBalanceId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public Date getPartyBalanceDate() {
        return partyBalanceDate;
    }

    public void setPartyBalanceDate(Date partyBalanceDate) {
        this.partyBalanceDate = partyBalanceDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getParty() {
        return party;
    }

    public void setParty(Long party) {
        this.party = party;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partyBalanceId != null ? partyBalanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PartyBalanceDTO)) {
            return false;
        }
        PartyBalanceDTO other = (PartyBalanceDTO) object;
        if ((this.partyBalanceId == null && other.partyBalanceId != null) || (this.partyBalanceId != null && !this.partyBalanceId.equals(other.partyBalanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.zahid.apps.web.pos.dto.PartyBalanceDTO[ partyBalanceId=" + partyBalanceId + " ]";
    }
}