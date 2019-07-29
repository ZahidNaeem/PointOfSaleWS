package org.zahid.apps.web.pos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zahid.apps.web.pos.dto.ItemDTO;
import org.zahid.apps.web.pos.entity.Item;
import org.zahid.apps.web.pos.entity.NavigationDtl;
import org.zahid.apps.web.pos.service.ItemService;

import java.util.List;


//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("item")
public class ItemRestController {

    private static final Logger LOG = LogManager.getLogger(ItemRestController.class);
    @Autowired
    ItemService itemService;

    private final int[] indx = {-1};

    @GetMapping("all")
    public List<Item> getAllItems() {
        return itemService.getItems();
    }

    @GetMapping("first")
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
    }

    @GetMapping("{id}")
    public Item getItemById(@PathVariable("id") final Long id) {
        return itemService.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ItemDTO saveItem(@RequestBody final Item item) {
        if (null == item.getItemCode()) {
            item.setItemCode(itemService.generateID() >= (getAllItems().size() + 1) ? itemService.generateID() : (getAllItems().size() + 1));
        }
        final Item itemSaved = itemService.save(item);
        indx[0] = this.getAllItems().indexOf(itemSaved);
        LOG.info("Index in saveItem(): {}", indx[0]);
        return getItemDTO(getAllItems(), indx[0]);
    }

    /*
     * This is not necessary because spring data jpa know either this item is new or existing
     */
    /*@PutMapping(consumes = "application/json", produces = "application/json")
    public Item updateItem(@RequestBody final Item item) {
        return itemService.save(item);
    }*/

    @DeleteMapping("{id}")
    public ItemDTO deleteItemById(@PathVariable("id") final Long id) {
        if (!itemService.exists(id)) {
            throw new IllegalArgumentException("Item with id: " + id + " does not exist");
        } else {
            try {
                itemService.deleteById(id);
                indx[0]--;
                LOG.info("Index in deleteItemById(): {}", indx[0]);
                return getItemDTO(getAllItems(), indx[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @DeleteMapping(consumes = "application/json", produces = "application/json")
    public ItemDTO deleteItem(@RequestBody final Item item) {
        LOG.info("Index: {}", indx);
        if (null == item || null == item.getItemCode() || !itemService.exists(item.getItemCode())) {
            throw new IllegalArgumentException("Item does not exist");
        } else {
            try {
                itemService.delete(item);
                indx[0]--;
                LOG.info("Index in deleteItem(): {}", indx[0]);
                return getItemDTO(getAllItems(), indx[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static final NavigationDtl resetNavigation() {
        NavigationDtl dtl = new NavigationDtl();
        dtl.setFirst(true);
        dtl.setLast(true);
        return dtl;
    }

    private static final ItemDTO getItemDTO(List<Item> items, int indx) {
        if (indx < 0 || indx > items.size() - 1) {
            LOG.info("Index in getItemDTO(): {}", indx);
            throw new IndexOutOfBoundsException();
        } else {
            final NavigationDtl dtl = resetNavigation();
            final Item item = items.get(indx);
            final ItemDTO itemDTO = new ItemDTO();
            itemDTO.setItem(item);
            if (indx > 0) {
                dtl.setFirst(false);
            }
            if (indx < items.size() - 1) {
                dtl.setLast(false);
            }
            itemDTO.setNavigationDtl(dtl);
            return itemDTO;
        }
    }
}
