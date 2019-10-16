package org.zahid.apps.web.pos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The persistent class for the XXUM_GROUPMEMBERS database table.
 */
@Entity
@Table(name = "XXUM_GROUPMEMBERS")
@NamedQueries({
        @NamedQuery(name = "Groupmember.findAll", query = "SELECT g FROM Groupmember g"),
        @NamedQuery(name = "Groupmember.findBygMember", query = "SELECT g FROM Groupmember g WHERE upper(gMember) = ?1")})
public class Groupmember extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    /*@SequenceGenerator(name = "XXUM_GROUPMEMBERS_GMID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XXUM_GROUPMEMBERS_GMID_GENERATOR")*/
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GM_ID")
    private Long gmId;

    @Column(name = "G_MEMBER")
    private String gMember;

    @Column(name = "G_NAME")
    private String gName;

    public Groupmember() {
    }

    public Long getGmId() {
        return gmId;
    }

    public void setGmId(Long gmId) {
        this.gmId = gmId;
    }

    public String getgMember() {
        return gMember;
    }

    public void setgMember(String gMember) {
        this.gMember = gMember;
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
        hash += (gmId != null ? gmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Groupmember)) {
            return false;
        }
        Groupmember other = (Groupmember) object;
        if ((this.gmId == null && other.gmId != null) || (this.gmId != null && !this.gmId.equals(other.gmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.zahid.apps.web.pos.entity.Groupmember[ gmId=" + gmId + " ]";
    }
}