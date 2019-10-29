package org.zahid.apps.web.pos.model;

import org.zahid.apps.web.pos.entity.Auditable;
import org.zahid.apps.web.pos.entity.AuditorDetail;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ItemStockModel  extends Auditable<AuditorDetail> implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long itemStockId;

  private Date itemStockDate;

  private BigDecimal qnty;

  private String remarks;

  private Long item;

  public Long getItemStockId() {
    return itemStockId;
  }

  public void setItemStockId(Long itemStockId) {
    this.itemStockId = itemStockId;
  }

  public Date getItemStockDate() {
    return itemStockDate;
  }

  public void setItemStockDate(Date itemStockDate) {
    this.itemStockDate = itemStockDate;
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
