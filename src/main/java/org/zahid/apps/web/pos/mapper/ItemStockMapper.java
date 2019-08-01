package org.zahid.apps.web.pos.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zahid.apps.web.pos.dto.ItemStockDTO;
import org.zahid.apps.web.pos.entity.ItemStock;
import org.zahid.apps.web.pos.service.ItemService;

@Component
public class ItemStockMapper {

  @Autowired
  private ItemService itemService;

  public ItemStock fromItemStockDTO(final ItemStockDTO dto) {
    final ItemStock stock = new ItemStock();
    stock.setItemStockId(dto.getItemStockId());
    stock.setItem(itemService.findById(dto.getItem()));
    stock.setItemStockDate(dto.getItemStockDate());
    stock.setQnty(dto.getQnty());
    stock.setRemarks(dto.getRemarks());
    stock.setCreatedBy(dto.getCreatedBy());
    stock.setCreationDate(dto.getCreationDate());
    stock.setLastUpdatedBy(dto.getLastUpdatedBy());
    stock.setLastUpdateDate(dto.getLastUpdateDate());
    return stock;
  }

  public ItemStockDTO toItemStockDTO(final ItemStock stock) {
    final ItemStockDTO dto = new ItemStockDTO();
    dto.setItemStockId(stock.getItemStockId());
    dto.setItem(stock.getItem().getItemCode());
    dto.setCreatedBy(stock.getCreatedBy());
    dto.setCreationDate(stock.getCreationDate());
    dto.setLastUpdatedBy(stock.getLastUpdatedBy());
    dto.setLastUpdateDate(stock.getLastUpdateDate());
    dto.setQnty(stock.getQnty());
    dto.setRemarks(stock.getRemarks());
    return dto;
  }

}
