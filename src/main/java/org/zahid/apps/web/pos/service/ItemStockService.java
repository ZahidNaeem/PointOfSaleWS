package org.zahid.apps.web.pos.service;

import org.zahid.apps.web.pos.entity.Item;
import org.zahid.apps.web.pos.entity.ItemStock;

import java.util.List;
import java.util.Set;

public interface ItemStockService {

    Long generateID();

    boolean exists(Long id);

    List<ItemStock> getItemStockList();

    List<ItemStock> getCurrentItemStockList();

    List<ItemStock> getCurrentItemStockListFromDB();

    List<ItemStock> getItemStockListFromDB(Item item);

    ItemStock findById(Long id);

    List<ItemStock> addStockToStockList(ItemStock stock);

    Item getCurrentItem();

    ItemStock attachStockWithItem(ItemStock stock);

//    List<ItemStock> attachStockWithItem(List<ItemStock> stocks);

//    List<ItemStock> findAllByItem(Item item);

    // ItemStock prepareCreate();

    ItemStock save(ItemStock itemStock);

    List<ItemStock> save(Set<ItemStock> itemStocks);

    void delete(ItemStock itemStock);

    void delete(Set<ItemStock> itemStocks);

    void deleteById(Long id);

    void deleteAll();

    void deleteAllInBatch();

    void deleteInBatch(Set<ItemStock> itemStocks);

}
