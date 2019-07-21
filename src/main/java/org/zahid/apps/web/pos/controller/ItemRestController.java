package org.zahid.apps.web.pos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zahid.apps.web.pos.entity.Item;
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
    public Item firstItem() {
        final List<Item> items = getAllItems();
        if (items.size() > 0) {
            indx[0] = 0;
            return items.get(indx[0]);
        }
        return null;
    }

    @GetMapping("previous")
    public Item previousItem() {
        final List<Item> items = getAllItems();
        if (items.size() > 0 && indx[0] > 0) {
            return items.get(--indx[0]);
        }
        return null;
    }

    @GetMapping("next")
    public Item nextItem() {
        final List<Item> items = getAllItems();
        if (items.size() > 0 && indx[0] < items.size() - 1) {
            return items.get(++indx[0]);
        }
        return null;
    }

    @GetMapping("last")
    public Item lastItem() {
        final List<Item> items = getAllItems();
        if (items.size() > 0) {
            indx[0] = items.size() - 1;
            return items.get(indx[0]);
        }
        return null;
    }

    @GetMapping("{id}")
    public Item getItemById(@PathVariable("id") Long id) {
        return itemService.findById(id);
    }
}
