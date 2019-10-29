package org.zahid.apps.web.pos.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the XXIM_ITEMS database table.
 */
@Entity
@Table(name = "XXIM_ITEMS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ITEM_DESC"})
})
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(scope = Item.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "itemCode")
//@JsonIdentityInfo(scope = Item.class, generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.generateID", query = "SELECT coalesce(max(itemCode), 0) + 1 FROM Item i"),
    @NamedQuery(name = "Item.getCategories", query = "SELECT distinct i.itemCategory FROM Item i where i.itemCategory is not null"),
    @NamedQuery(name = "Item.getItemDesc", query = "SELECT i.itemDesc FROM Item i where i.itemCode = :itemCode")
})
public class Item extends Auditable<User> implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
//    @SequenceGenerator(name = "XXIM_ITEMS_ITEMCODE_GENERATOR", sequenceName = "XXIM_ITEMS_ITEMCODE_GENERATOR", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XXIM_ITEMS_ITEMCODE_GENERATOR")
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ITEM_CODE")
  private Long itemCode;

  @Temporal(TemporalType.DATE)
  @Column(name = "EFFECTIVE_END_DATE")
  private Date effectiveEndDate;

  @Temporal(TemporalType.DATE)
  @Column(name = "EFFECTIVE_START_DATE")
  private Date effectiveStartDate;

  @Column(name = "ITEM_BARCODE")
  private String itemBarcode;

  @Column(name = "ITEM_CATEGORY")
  private String itemCategory;

  @Column(name = "ITEM_DESC", unique = true)
  private String itemDesc;

  @Column(name = "ITEM_UOM")
  private String itemUom;

  @Column(name = "MAX_STOCK")
  private BigDecimal maxStock;

  @Column(name = "MIN_STOCK")
  private BigDecimal minStock;

  @Column(name = "PURCHASE_PRICE")
  private BigDecimal purchasePrice;

  @Column(name = "SALE_PRICE")
  private BigDecimal salePrice;

  // bi-directional many-to-one association to InvoiceDtl
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
  private List<InvoiceDtl> invoiceDtls;

  // bi-directional many-to-one association to ItemStock
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
//    @JsonIdentityReference
  private List<ItemStock> itemStocks;

  public Item() {
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

  public List<InvoiceDtl> getInvoiceDtls() {
    return invoiceDtls;
  }

  public void setInvoiceDtls(List<InvoiceDtl> invoiceDtls) {
    this.invoiceDtls = invoiceDtls;
  }

  public List<ItemStock> getItemStocks() {
    return itemStocks;
  }

  public void setItemStocks(List<ItemStock> itemStocks) {
    this.itemStocks = itemStocks;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (itemCode != null ? itemCode.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Item)) {
      return false;
    }
    Item other = (Item) object;
    if ((this.itemCode == null && other.itemCode != null) || (this.itemCode != null
        && !this.itemCode.equals(other.itemCode))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "org.zahid.apps.web.pos.entity.Item[ itemCode=" + itemCode + " & itemDesc=" + itemDesc
        + " ]";
  }
}