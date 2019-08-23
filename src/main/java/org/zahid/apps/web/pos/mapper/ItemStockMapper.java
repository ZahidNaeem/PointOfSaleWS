package org.zahid.apps.web.pos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.zahid.apps.web.pos.dto.ItemStockDTO;
import org.zahid.apps.web.pos.entity.ItemStock;
import org.zahid.apps.web.pos.service.ItemService;

@Mapper(componentModel = "spring")
public interface ItemStockMapper {

  @Mapping(target = "item", expression = "java(itemService.findById(dto.getItem()))")
  ItemStock ItemStockDTOToItemStock(final ItemStockDTO dto, final ItemService itemService);

  @Mapping(target = "item", expression = "java(itemStock.getItem().getItemCode())")
  ItemStockDTO ItemStockToItemStockDTO(final ItemStock itemStock);

  // Below commented code was added to test how multiple custom mappings with same datatypes will be performed

  /*
  @Mapping(target = "item2", source = "dto.item2", qualifiedByName = "diItem2")
  @Mapping(target = "item3", source = "dto.item3", qualifiedByName = "diItem3")
  ItemStock ItemStockDTOToItemStock(final ItemStockDTO dto, final ItemService itemService);

  @Mapping(target = "item2", source = "itemStock.item2", qualifiedByName = "idItem2")
  @Mapping(target = "item3", source = "itemStock.item3", qualifiedByName = "idItem3")
  ItemStockDTO ItemStockToItemStockDTO(final ItemStock itemStock);

  @Named("diItem2")
  default Item mapItem2(Long value) {
    return null;
  }

  @Named("diItem3")
  default Item mapItem3(Long value) {
    return null;
  }

  @Named("idItem2")
  default Long mapItem2(Item value) {
    return null;
  }

  @Named("idItem3")
  default Long mapItem3(Item value) {
    return null;
  }
  */
}
