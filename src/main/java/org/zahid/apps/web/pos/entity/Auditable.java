package org.zahid.apps.web.pos.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    @Embedded
    @CreatedBy
    @Column(name = "CREATED_BY")
    protected U createdBy;


    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name = "CREATION_DATE")
    protected Date creationDate;

    @Embedded
    @LastModifiedBy
    @Column(name = "LAST_UPDATED_BY")
    protected U lastUpdatedBy;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE")
    protected Date lastUpdateDate;

    public U getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(U createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public U getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(U lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
