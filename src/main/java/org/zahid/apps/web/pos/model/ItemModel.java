package org.zahid.apps.web.pos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.zahid.apps.web.pos.entity.Auditable;
import org.zahid.apps.web.pos.entity.User;

public class ItemModel  extends Auditable<User> implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long itemCode;
  private Date effectiveEndDate;
  private Date effectiveStartDate;
  private String itemBarcode;
  private String itemCategory;
  private String itemDesc;
  private String itemUom;
  private BigDecimal maxStock;
  private BigDecimal minStock;
  private BigDecimal purchasePrice;
  private BigDecimal salePrice;
  private List<InvoiceDtlModel> invoiceDtls;
  private List<ItemStockModel> itemStocks;

  public ItemModel() {
  }

  public Long getItemCode() {
    return itemCode;
  }

  public void setItemCode(Long itemCode) {
    this.itemCode = itemCode;
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

  public String getItemBarcode() {
    return itemBarcode;
  }

  public void setItemBarcode(String itemBarcode) {
    this.itemBarcode = itemBarcode;
  }

  public String getItemCategory() {
    return itemCategory;
  }

  public void setItemCategory(String itemCategory) {
    this.itemCategory = itemCategory;
  }

  public String getItemDesc() {
    return itemDesc;
  }

  public void setItemDesc(String itemDesc) {
    this.itemDesc = itemDesc;
  }

  public String getItemUom() {
    return itemUom;
  }

  public void setItemUom(String itemUom) {
    this.itemUom = itemUom;
  }

  public BigDecimal getMaxStock() {
    return maxStock;
  }

  public void setMaxStock(BigDecimal maxStock) {
    this.maxStock = maxStock;
  }

  public BigDecimal getMinStock() {
    return minStock;
  }

  public void setMinStock(BigDecimal minStock) {
    this.minStock = minStock;
  }

  public BigDecimal getPurchasePrice() {
    return purchasePrice;
  }

  public void setPurchasePrice(BigDecimal purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  public BigDecimal getSalePrice() {
    return salePrice;
  }

  public void setSalePrice(BigDecimal salePrice) {
    this.salePrice = salePrice;
  }

  public List<InvoiceDtlModel> getInvoiceDtls() {
    return invoiceDtls;
  }

  public void setInvoiceDtls(List<InvoiceDtlModel> invoiceDtls) {
    this.invoiceDtls = invoiceDtls;
  }

  public List<ItemStockModel> getItemStocks() {
    return itemStocks;
  }

  public void setItemStocks(List<ItemStockModel> itemStocks) {
    this.itemStocks = itemStocks;
  }

  public int hashCode() {
    int hash = 0;
    hash += (itemCode != null ? itemCode.hashCode() : 0);
    return hash;
  }

  public boolean equals(Object object) {
    if (!(object instanceof ItemModel)) {
      return false;
    }
    ItemModel other = (ItemModel) object;
    if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null
        && !this.itemCode.equals(other.itemCode))) {
      return false;
    }
    return true;
  }

  public String toString() {
    return "org.zahid.apps.web.pos.entity.ItemModel[ itemCode=" + itemCode + " & itemDesc="
        + itemDesc
        + " ]";
  }
}