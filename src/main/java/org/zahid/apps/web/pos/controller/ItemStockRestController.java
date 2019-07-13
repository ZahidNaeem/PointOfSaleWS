package org.zahid.apps.web.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zahid.apps.web.pos.entity.ItemStock;
import org.zahid.apps.web.pos.service.ItemStockService;

import java.util.List;

@RestController
@RequestMapping("stock")
public class ItemStockRestController {
    @Autowired
    private ItemStockService stockService;

    @GetMapping("all")
    public List<ItemStock> findAll() {
return stockService.getItemStockList();
    }
}
