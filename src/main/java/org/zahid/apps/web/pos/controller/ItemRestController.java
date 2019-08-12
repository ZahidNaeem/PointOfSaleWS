package org.zahid.apps.web.pos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.zahid.apps.web.pos.dto.ItemDTO;
import org.zahid.apps.web.pos.entity.Item;
import org.zahid.apps.web.pos.entity.NavigationDtl;
import org.zahid.apps.web.pos.service.ItemService;

import java.util.List;
import java.util.Set;


//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("item")
public class ItemRestController {

    private static final Logger LOG = LogManager.getLogger(ItemRestController.class);
    @Autowired
    private ItemService itemService;

    private final int[] indx = {-1};

    @GetMapping("all")
    public List<Item> findAll() {
        return itemService.getItems();
    }

    @GetMapping("{id}")
    public ItemDTO findById(@PathVariable("id") final Long id) {
        final Item item = itemService.findById(id);
        indx[0] = findAll().indexOf(item);
        LOG.info("Index in findById(): {}", indx[0]);
        return getItemDTO(findAll(), indx[0]);
    }

    @GetMapping("first")
    public ItemDTO first() {
        indx[0] = 0;
        LOG.info("Index in first(): {}", indx[0]);
        return getItemDTO(findAll(), indx[0]);
    }

    @GetMapping("previous")
    public ItemDTO previous() {
        indx[0]--;
        LOG.info("Index in previous(): {}", indx[0]);
        return getItemDTO(findAll(), indx[0]);
    }

    @GetMapping("next")
    public ItemDTO next() {
        indx[0]++;
        LOG.info("Index in next(): {}", indx[0]);
        return getItemDTO(findAll(), indx[0]);
    }

    @GetMapping("last")
    public ItemDTO last() {
        indx[0] = findAll().size() - 1;
        LOG.info("Index in last(): {}", indx[0]);
        return getItemDTO(findAll(), indx[0]);
    }

    @GetMapping("cats")
    public Set<String> findAllCategories() {
        return itemService.getItemCategories();
    }

    @GetMapping("uoms")
    public Set<String> findAllUOMs() {
        return itemService.getItemUOM();
    }

    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDTO save(@RequestBody final Item item) {
        /*if (null == item.getItemCode()) {
            item.setItemCode(itemService.generateID() >= (findAll().size() + 1) ? itemService.generateID() : (findAll().size() + 1));
        }*/
        final Item itemSaved = itemService.save(item);
        indx[0] = this.findAll().indexOf(itemSaved);
        LOG.info("Index in saveItem(): {}", indx[0]);
        return getItemDTO(findAll(), indx[0]);
    }

    @PostMapping(path = "saveAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> saveAll(@RequestBody final Set<Item> items) {
        return itemService.save(items);
    }

    @DeleteMapping("/delete/{id}")
    public ItemDTO deleteById(@PathVariable("id") final Long id) {
        if (!itemService.exists(id)) {
            throw new IllegalArgumentException("Item with id: " + id + " does not exist");
        } else {
            try {
                itemService.deleteById(id);
                indx[0]--;
                LOG.info("Index in deleteItemById(): {}", indx[0]);
                return getItemDTO(findAll(), indx[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @DeleteMapping(path = "delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDTO delete(@RequestBody final Item item) {
        LOG.info("Index: {}", indx);
        if (null == item || null == item.getItemCode() || !itemService.exists(item.getItemCode())) {
            throw new IllegalArgumentException("Item does not exist");
        } else {
            try {
                itemService.delete(item);
                indx[0]--;
                LOG.info("Index in deleteItem(): {}", indx[0]);
                return getItemDTO(findAll(), indx[0]);
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
