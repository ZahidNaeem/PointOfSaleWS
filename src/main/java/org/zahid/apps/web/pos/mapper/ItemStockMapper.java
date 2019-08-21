package org.zahid.apps.web.pos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.zahid.apps.web.pos.dto.ItemStockDTO;
import org.zahid.apps.web.pos.entity.Item;
import org.zahid.apps.web.pos.entity.ItemStock;
import org.zahid.apps.web.pos.service.ItemService;

@Mapper(componentModel = "spring")
public interface ItemStockMapper {

  @Mapping(target = "item", expression = "java(itemService.findById(dto.getItem()))")
  ItemStock ItemStockDTOToItemStock(final ItemStockDTO dto, final ItemService itemService);

  @Mapping(target = "item", expression = "java(itemStock.getItem().getItemCode())")
  ItemStockDTO ItemStockToItemStockDTO(final ItemStock itemStock);
}
