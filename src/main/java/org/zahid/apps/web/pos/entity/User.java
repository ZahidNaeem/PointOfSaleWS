package org.zahid.apps.web.pos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The persistent class for the XXUM_USERS database table.
 */
@Entity
@Table(name = "XXUM_USERS")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    /*@SequenceGenerator(name = "XXUM_USERS_UID_GENERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XXUM_USERS_UID_GENERATOR")*/
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "U_ID")
    private Long uId;

    @Column(name = "U_DESCRIPTION")
    private String uDescription;

    @Column(name = "U_NAME")
    private String uName;

    @Column(name = "U_PASSWORD")
    private String uPassword;

    public User() {
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuDescription() {
        return uDescription;
    }

    public void setuDescription(String uDescription) {
        this.uDescription = uDescription;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.zahid.apps.web.pos.entity.User[ uId=" + uId + " ]";
    }
}