package org.zahid.apps.web.pos.dto;

import java.io.Serializable;
import org.zahid.apps.web.pos.entity.NavigationDtl;
import org.zahid.apps.web.pos.model.ItemModel;

public class ItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private NavigationDtl navigationDtl;
    private ItemModel item;

    public NavigationDtl getNavigationDtl() {
        return navigationDtl;
    }

    public void setNavigationDtl(NavigationDtl navigationDtl) {
        this.navigationDtl = navigationDtl;
    }

    public ItemModel getItem() {
        return item;
    }

    public void setItem(ItemModel item) {
        this.item = item;
    }
}
