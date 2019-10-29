package org.zahid.apps.web.pos.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the XXIM_ITEM_STOCK database table.
 */
@Entity
@Table(name = "XXIM_ITEM_STOCK")
@JsonIdentityInfo(scope = ItemStock.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "itemStockId")
//@JsonIdentityInfo(scope = ItemStock.class, generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
@NamedQueries({
    @NamedQuery(name = "ItemStock.findAll", query = "SELECT i FROM ItemStock i"),
    @NamedQuery(name = "ItemStock.findAllByItem", query = "SELECT i FROM ItemStock i where i.item.itemCode = ?1"),
    @NamedQuery(name = "ItemStock.generateID", query = "SELECT coalesce(max(itemStockId), 0) + 1 FROM ItemStock i")
})
public class ItemStock extends Auditable<User> implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
//    @SequenceGenerator(name = "XXIM_ITEM_STOCK_ITEMSTOCKID_GENERATOR")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XXIM_ITEM_STOCK_ITEMSTOCKID_GENERATOR")
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ITEM_STOCK_ID")
  private Long itemStockId;

  @Temporal(TemporalType.DATE)
  @Column(name = "ITEM_STOCK_DATE")
  private Date itemStockDate;

  private BigDecimal qnty;

  private String remarks;

  // bi-directional many-to-one association to Item
  @ManyToOne
//  @NotNull
  @JoinColumn(name = "ITEM_CODE")
//    @JsonIdentityReference
  private Item item;

  public ItemStock() {
  }

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

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
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
    if (!(object instanceof ItemStock)) {
      return false;
    }
    ItemStock other = (ItemStock) object;
    if ((this.itemStockId == null && other.itemStockId != null) || (this.itemStockId != null
        && !this.itemStockId.equals(other.itemStockId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "org.zahid.apps.web.pos.entity.ItemStock[ itemStockId=" + itemStockId + " ]";
  }
}