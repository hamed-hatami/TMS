package ir.university.toosi.tms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Set;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

@JsonIgnoreProperties(value = "@id")
public class WorkGroup implements Serializable {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String persianDescription;
    @JsonProperty
    private String englishDescription;
    @JsonProperty
    private String enabled;
    @JsonProperty
    private String deleted;
    @JsonProperty
    private boolean selected;
    @JsonProperty
    private Set<User> users;


    public WorkGroup() {
    }

    public WorkGroup(Set<User> users) {
        this.users = users;
    }

    public WorkGroup(long id, String name, String persianDescription, String englishDescription, String enabled, String deleted, boolean selected, Set<User> users) {
        this.id = id;
        this.name = name;
        this.persianDescription = persianDescription;
        this.englishDescription = englishDescription;
        this.enabled = enabled;
        this.deleted = deleted;
        this.selected = selected;
        this.users = users;
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
}