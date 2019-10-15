package org.zahid.apps.web.pos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ItemStockModel implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long itemStockId;

  private String createdBy;

  private Timestamp creationDate;

  private Date itemStockDate;

  private Timestamp lastUpdateDate;

  private String lastUpdatedBy;

  private BigDecimal qnty;

  private String remarks;

  private Long item;

  public Long getItemStockId() {
    return itemStockId;
  }

  public void setItemStockId(Long itemStockId) {
    this.itemStockId = itemStockId;
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

  public Date getItemStockDate() {
    return itemStockDate;
  }

  public void setItemStockDate(Date itemStockDate) {
    this.itemStockDate = itemStockDate;
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

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public Long getItem() {
    return item;
  }

  public void setItem(Long item) {
    this.item = item;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (itemStockId != null ? itemStockId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ItemStockModel)) {
      return false;
    }
    ItemStockModel other = (ItemStockModel) object;
    if ((this.itemStockId == null && other.itemStockId != null) || (this.itemStockId != null && !this.itemStockId.equals(other.itemStockId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "org.zahid.apps.web.pos.model.ItemStockModel[ itemStockId=" + itemStockId + " ]";
  }
}
