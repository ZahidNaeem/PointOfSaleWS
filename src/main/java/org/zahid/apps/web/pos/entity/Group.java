package org.zahid.apps.web.pos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The persistent class for the XXUM_GROUPS database table.
 */
@Entity
@Table(name = "XXUM_GROUPS")
@NamedQuery(name = "Group.findAll", query = "SELECT g FROM Group g")
public class Group extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    /*@SequenceGenerator(name = "XXUM_GROUPS_GID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XXUM_GROUPS_GID_GENERATOR")*/
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "G_ID")
    private Long gId;

    @Column(name = "G_DESCRIPTION")
    private String gDescription;

    @Column(name = "G_NAME")
    private String gName;

    public Group() {
    }

    public Long getgId() {
        return gId;
    }

    public void setgId(Long gId) {
        this.gId = gId;
    }

    public String getgDescription() {
        return gDescription;
    }

    public void setgDescription(String gDescription) {
        this.gDescription = gDescription;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gId != null ? gId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Group)) {
            return false;
        }
        Group other = (Group) object;
        if ((this.gId == null && other.gId != null) || (this.gId != null && !this.gId.equals(other.gId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.zahid.apps.web.pos.entity.Group[ gId=" + gId + " ]";
    }
}