package org.zahid.apps.web.pos.entity;

import javax.persistence.Embeddable;

@Embeddable
public class AuditorDetail {
    private String username;
    private Organization organization;

    public AuditorDetail() {
    }

    public AuditorDetail(final String username, final Organization organization) {
        this.username = username;
        this.organization = organization;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

}