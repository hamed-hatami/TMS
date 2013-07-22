package ir.university.toosi.tms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(value = "@id")
public class Lookup implements Serializable {

    @JsonProperty
    private long id;

    @JsonProperty
    private String code;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private String persianName;

    @JsonProperty
    private boolean definable;

    @JsonProperty
    private Set<ir.university.toosi.tms.model.entity.BLookup> BLookup = new HashSet<ir.university.toosi.tms.model.entity.BLookup>();

    public Lookup(String code, String name, String description, Set<ir.university.toosi.tms.model.entity.BLookup> BLookup) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.BLookup = BLookup;
    }


    public Lookup() {
    }

    public Lookup(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ir.university.toosi.tms.model.entity.BLookup> getBLookup() {
        return BLookup;
    }

    public void setBLookup(Set<ir.university.toosi.tms.model.entity.BLookup> BLookup) {
        this.BLookup = BLookup;
    }

    public String getPersianName() {
        return persianName;
    }

    public void setPersianName(String persianName) {
        this.persianName = persianName;
    }

    public boolean isDefinable() {
        return definable;
    }

    public void setDefinable(boolean definable) {
        this.definable = definable;
    }
}
