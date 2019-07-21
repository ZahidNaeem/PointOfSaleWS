package org.zahid.apps.web.pos.dto;

import org.zahid.apps.web.pos.entity.Item;
import org.zahid.apps.web.pos.entity.NavigationDtl;

public class ItemDTO {
    private NavigationDtl navigationDtl;
    private Item item;

    public NavigationDtl getNavigationDtl() {
        return navigationDtl;
    }

    public void setNavigationDtl(NavigationDtl navigationDtl) {
        this.navigationDtl = navigationDtl;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
