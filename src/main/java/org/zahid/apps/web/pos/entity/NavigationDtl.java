package org.zahid.apps.web.pos.entity;

import java.io.Serializable;

public class NavigationDtl implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean first;
    private boolean last;

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}
