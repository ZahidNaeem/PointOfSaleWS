package org.zahid.apps.web.pos.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zahid.apps.web.pos.entity.ItemStock;
import org.zahid.apps.web.pos.service.ItemStockService;


//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("stock")
public class ItemStockRestController {

  private static final Logger LOG = LogManager.getLogger(ItemRestController.class);
  @Autowired
  private ItemStockService stockService;

  @GetMapping("all")
  public List<ItemStock> findAll() {
    return stockService.getItemStockList();
  }

  /*@GetMapping("first")
  public ItemDTO first() {
    indx[0] = 0;
    LOG.info("Index in first(): {}", indx[0]);
    return getItemDTO(getAllItems(), indx[0]);
  }

  @GetMapping("previous")
  public ItemDTO previousItem() {
    indx[0]--;
    LOG.info("Index in previous(): {}", indx[0]);
    return getItemDTO(getAllItems(), indx[0]);
  }

  @GetMapping("next")
  public ItemDTO nextItem() {
    indx[0]++;
    LOG.info("Index in next(): {}", indx[0]);
    return getItemDTO(getAllItems(), indx[0]);
  }

  @GetMapping("last")
  public ItemDTO lastItem() {
    indx[0] = getAllItems().size() - 1;
    LOG.info("Index in last(): {}", indx[0]);
    return getItemDTO(getAllItems(), indx[0]);
  }*/

  @GetMapping("{id}")
  public ItemStock getItemStockById(@PathVariable("id") final Long id) {
    return stockService.findById(id);
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public ItemStock saveItemStock(@RequestBody final ItemStock stock) {
    if (null == stock.getItemStockId()) {
      stock.setItemStockId(stockService.generateID() >= (findAll().size() + 1) ? stockService.generateID() : (findAll().size() + 1));
    }
    return stockService.save(stock);
  }

  @DeleteMapping("{id}")
  public boolean deleteItemStockById(@PathVariable("id") final Long id) {
    if (!stockService.exists(id)) {
      throw new IllegalArgumentException("Item stock with id: " + id + " does not exist");
    } else {
      try {
        stockService.deleteById(id);
        return true;
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }
  }

  @DeleteMapping(consumes = "application/json", produces = "application/json")
  public boolean deleteItemStock(@RequestBody final ItemStock stock) {
    if (null == stock || null == stock.getItemStockId() || !stockService.exists(stock.getItemStockId())) {
      throw new IllegalArgumentException("Item stock does not exist");
    } else {
      try {
        stockService.delete(stock);
        return true;
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }
  }
}
