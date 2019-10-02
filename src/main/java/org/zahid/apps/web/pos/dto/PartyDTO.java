package org.zahid.apps.web.pos.dto;

import org.zahid.apps.web.pos.entity.Party;
import org.zahid.apps.web.pos.entity.NavigationDtl;

import java.io.Serializable;

public class PartyDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private NavigationDtl navigationDtl;
    private Party party;

    public NavigationDtl getNavigationDtl() {
        return navigationDtl;
    }

    public void setNavigationDtl(NavigationDtl navigationDtl) {
        this.navigationDtl = navigationDtl;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }
}
