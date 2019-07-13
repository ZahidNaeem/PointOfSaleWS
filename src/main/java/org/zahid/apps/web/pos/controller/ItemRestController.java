package org.zahid.apps.web.pos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("all")
    public List<Item> getAllItems() {
        LOG.info("getAllItems Called");
        final List<Item> items = itemService.getItems();
        return items;
    }

    @GetMapping("{id}")
    public Item getItemById(@PathVariable("id") Long id) {
        return itemService.findById(id);
    }
}
