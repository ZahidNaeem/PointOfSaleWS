package org.zahid.apps.web.pos.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.zahid.apps.web.pos.controller.SecurityController;
import org.zahid.apps.web.pos.entity.Item;
import org.zahid.apps.web.pos.entity.ItemStock;
import org.zahid.apps.web.pos.exception.ItemStockNotFoundException;
import org.zahid.apps.web.pos.repo.ItemStockRepo;
import org.zahid.apps.web.pos.service.ItemStockService;

@Service
public class ItemStockServiceImpl implements ItemStockService {

    @Autowired
    private ItemStockRepo itemStockRepo;
    private final Logger LOG = LogManager.getLogger(ItemStockServiceImpl.class);

    @Override
    public Long generateID() {
        return itemStockRepo.generateID();
    }

    @Override
    public boolean exists(Long id) {
        return itemStockRepo.existsById(id);
    }

    @Override
    public List<ItemStock> getItemStockList() {
        return itemStockRepo.findAll();
    }

    @Override
    public List<ItemStock> getCurrentItemStockList() {
        // TODO:
        return null;
    }

    @Override
    public List<ItemStock> getCurrentItemStockListFromDB() {
        // TODO:
        return null;
    }

    @Override
    public List<ItemStock> getItemStockListFromDB(Item item) {
        return itemStockRepo.findAllByItem(item);
    }

    @Override
    public ItemStock findById(Long id) {
        final Optional<ItemStock> stock = itemStockRepo.findById(id);
        if (stock.isPresent()) {
            return stock.get();
        }
        throw new ItemStockNotFoundException("Item stock with id " + id + " not found");
    }

    //	@Override
//	public List<ItemStock> findAllByItem(Item item) {
//		return item.getItemStocks();
//	}
    @Override
    public List<ItemStock> addStockToStockList(ItemStock stock) {
        getCurrentItemStockList().add(stock);
        return getCurrentItemStockList();
    }

    @Override
    public Item getCurrentItem() {
        // TODO:
        return null;
    }

    @Override
    public ItemStock attachStockWithItem(ItemStock stock) {
        /*itemController.getNavigationController().object.getItemStocks().add(stock);
        return stock;*/
        // TODO:
        return null;
    }

//    @Override
//    public List<ItemStock> attachStockWithItem(List<ItemStock> stocks) {
//        --itemController.getNavigationController().object.getItemStocks().addAll(stocks);
//        return stocks;
//    }

    //	@Override
//	public ItemStock prepareCreate() {
//		ItemStock stock = new ItemStock();
//		stock.setItem(itemController.getNavigationController().object);
//		itemController.getNavigationController().object.getItemStocks().add(stock);
//		return stock;
//	}
    @Override
    public ItemStock save(ItemStock itemStock) {
        String user = (new SecurityController()).getUsername();
        LOG.log(Level.INFO, "User: {0}", user);
        Timestamp currTime = new Timestamp(System.currentTimeMillis());
        if (!itemStockRepo.existsById(itemStock.getItemStockId())) {
            itemStock.setCreatedBy(user);
            itemStock.setCreationDate(currTime);
        }
        itemStock.setLastUpdatedBy(user);
        itemStock.setLastUpdateDate(currTime);
        return itemStockRepo.save(itemStock);
    }

    @Override
    public List<ItemStock> save(Set<ItemStock> itemStocks) {
        for (ItemStock itemStock : itemStocks) {
            String user = (new SecurityController()).getUsername();
            Timestamp currTime = new Timestamp(System.currentTimeMillis());
            if (itemStock.getItemStockId() == null || !itemStockRepo.existsById(itemStock.getItemStockId())) {
                itemStock.setCreatedBy(user);
                itemStock.setCreationDate(currTime);
            }
            itemStock.setLastUpdatedBy(user);
            itemStock.setLastUpdateDate(currTime);
        }
        return itemStockRepo.saveAll(itemStocks);
    }

    @Override
    public void delete(ItemStock itemStock) throws DataIntegrityViolationException {
        itemStockRepo.delete(itemStock);
    }

    @Override
    public void delete(Set<ItemStock> itemStocks) throws DataIntegrityViolationException {
        itemStockRepo.deleteAll(itemStocks);
    }

    @Override
    public void deleteById(Long id) throws DataIntegrityViolationException {
        itemStockRepo.deleteById(id);
    }

    @Override
    public void deleteAll() throws DataIntegrityViolationException {
        itemStockRepo.deleteAll();
    }

    @Override
    public void deleteAllInBatch() throws DataIntegrityViolationException {
        itemStockRepo.deleteAllInBatch();
    }

    @Override
    public void deleteInBatch(Set<ItemStock> itemStocks) throws DataIntegrityViolationException {
        itemStockRepo.deleteInBatch(itemStocks);
    }

}
