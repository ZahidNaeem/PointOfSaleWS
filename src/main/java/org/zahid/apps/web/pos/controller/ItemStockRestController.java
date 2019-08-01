package org.zahid.apps.web.pos.controller;

import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.zahid.apps.web.pos.dto.ItemStockDTO;
import org.zahid.apps.web.pos.entity.ItemStock;
import org.zahid.apps.web.pos.mapper.ItemStockMapper;
import org.zahid.apps.web.pos.service.ItemStockService;

import java.util.List;
import java.util.Set;


//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("stock")
public class ItemStockRestController {

    private static final Logger LOG = LogManager.getLogger(ItemRestController.class);
    @Autowired
    private ItemStockService stockService;

    @Autowired
    private ItemStockMapper stockMapper;

    @GetMapping("all")
    public List<ItemStock> findAll() {
        return stockService.getItemStockList();
    }

  /*@GetMapping("first")
  public ItemDTO first() {
    indx[0] = 0;
    LOG.info("Index in first(): {}", indx[0]);
    return getItemDTO(findAll(), indx[0]);
  }

  @GetMapping("previous")
  public ItemDTO previousItem() {
    indx[0]--;
    LOG.info("Index in previous(): {}", indx[0]);
    return getItemDTO(findAll(), indx[0]);
  }

  @GetMapping("next")
  public ItemDTO nextItem() {
    indx[0]++;
    LOG.info("Index in next(): {}", indx[0]);
    return getItemDTO(findAll(), indx[0]);
  }

  @GetMapping("last")
  public ItemDTO lastItem() {
    indx[0] = findAll().size() - 1;
    LOG.info("Index in last(): {}", indx[0]);
    return getItemDTO(findAll(), indx[0]);
  }*/

    @GetMapping("{id}")
    public ItemStock findById(@PathVariable("id") final Long id) {
        return stockService.findById(id);
    }

    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemStock save(@RequestBody final ItemStock stock) {
        /*if (null == stock.getItemStockId()) {
            stock.setItemStockId(stockService.generateID() >= (findAll().size() + 1) ? stockService.generateID() : (findAll().size() + 1));
        }*/
        return stockService.save(stock);
    }

    @PostMapping(path = "saveAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemStock> saveAll(@RequestBody final Set<ItemStockDTO> stockDTO) {
        final Set<ItemStock> stocks = new HashSet<>();
        stockDTO.forEach(dto -> {
            final ItemStock stock = stockMapper.fromItemStockDTO(dto);
            LOG.info("Stock Date: ", stock.getItemStockDate());
            LOG.info("DTO Stock Date: ", stock.getItemStockDate());
            stocks.add(stock);
        });
        return stockService.save(stocks);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteById(@PathVariable("id") final Long id) {
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

    @DeleteMapping(path = "delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@RequestBody final ItemStock stock) {
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
