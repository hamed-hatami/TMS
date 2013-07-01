package ir.university.toosi.tms.model.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */


public class WorkGroup implements Serializable {

    private long id;
    private String name;
    private String persianDescription;
    private String englishDescription;
    private String enabled;
    private String deleted;
    private boolean selected;
    private Set<User> users;
    private Set<Role> roles;


    public WorkGroup() {
    }

    public WorkGroup(long id, String name, String persianDescription, String englishDescription, String enabled, String deleted, boolean selected, Set<User> users, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.persianDescription = persianDescription;
        this.englishDescription = englishDescription;
        this.enabled = enabled;
        this.deleted = deleted;
        this.selected = selected;
        this.users = users;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersianDescription() {
        return persianDescription;
    }

    public void setPersianDescription(String persianDescription) {
        this.persianDescription = persianDescription;
    }

    public String getEnglishDescription() {
        return englishDescription;
    }

    public void setEnglishDescription(String englishDescription) {
        this.englishDescription = englishDescription;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}