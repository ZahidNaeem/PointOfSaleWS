package org.zahid.apps.web.pos.mapper;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.zahid.apps.web.pos.dto.ItemStockDTO;
import org.zahid.apps.web.pos.entity.Item;
import org.zahid.apps.web.pos.entity.ItemStock;
import org.zahid.apps.web.pos.service.ItemService;

@Mapper(componentModel = "spring")
public abstract class ItemStockMapper {

  @Autowired
  private ItemService itemService;

  public abstract ItemStock ItemStockDTOToItemStock(final ItemStockDTO itemStockDTO);

  public abstract ItemStockDTO ItemStockToItemStockDTO(final ItemStock itemStock);

  public Item map(final Long itemId) {
    return itemService.findById(itemId);
  }

  public Long map(final Item item) {
    return item.getItemCode();
  }
}
