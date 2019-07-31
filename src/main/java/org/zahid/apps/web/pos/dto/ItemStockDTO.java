package org.zahid.apps.web.pos.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ItemStockDTO {

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
}
