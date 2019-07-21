package org.zahid.apps.web.pos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ItemDTO firstItem() {
        final List<Item> items = getAllItems();
        final NavigationDtl navigationDtl = resetNavigation();
        final ItemDTO itemDTO = new ItemDTO();
        if (items.size() > 0) {
            indx[0] = 0;
            if (items.size() > 1) {
                navigationDtl.setLast(false);
            }
            itemDTO.setNavigationDtl(navigationDtl);
            itemDTO.setItem(items.get(indx[0]));
            return itemDTO;
        }
        return null;
    }

    @GetMapping("previous")
    public ItemDTO previousItem() {
        final List<Item> items = getAllItems();
        final NavigationDtl navigationDtl = resetNavigation();
        final ItemDTO itemDTO = new ItemDTO();
        if (items.size() > 0 && indx[0] > 0) {
            final Item item = items.get(--indx[0]);
            navigationDtl.setLast(false);
            if (indx[0] > 0) {
                navigationDtl.setFirst(false);
            }
            itemDTO.setItem(item);
            itemDTO.setNavigationDtl(navigationDtl);
            return itemDTO;
        }
        return null;
    }

    @GetMapping("next")
    public ItemDTO nextItem() {
        final List<Item> items = getAllItems();
        final NavigationDtl navigationDtl = resetNavigation();
        final ItemDTO itemDTO = new ItemDTO();
        if (items.size() > 0 && indx[0] < items.size() - 1) {
            final Item item = items.get(++indx[0]);
            navigationDtl.setFirst(false);
            if (indx[0] < items.size() - 1) {
                navigationDtl.setLast(false);
            }
            itemDTO.setItem(item);
            itemDTO.setNavigationDtl(navigationDtl);
            return itemDTO;
        }
        return null;
    }

    @GetMapping("last")
    public ItemDTO lastItem() {
        final List<Item> items = getAllItems();
        final NavigationDtl navigationDtl = resetNavigation();
        final ItemDTO itemDTO = new ItemDTO();
        if (items.size() > 0) {
            indx[0] = items.size() - 1;
            if (items.size() > 1) {
                navigationDtl.setFirst(false);
            }
            itemDTO.setNavigationDtl(navigationDtl);
            itemDTO.setItem(items.get(indx[0]));
            return itemDTO;
        }
        return null;
    }

    @GetMapping("{id}")
    public Item getItemById(@PathVariable("id") Long id) {
        return itemService.findById(id);
    }

    private NavigationDtl resetNavigation() {
        NavigationDtl dtl = new NavigationDtl();
        dtl.setFirst(true);
        dtl.setLast(true);
        return dtl;
    }
}
