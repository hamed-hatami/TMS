package ir.university.toosi.tms.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties(value = "@id")
public class BLookup implements Serializable {

    @JsonProperty
    private long id;

    @JsonProperty
    private String code;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private Lookup lookup;

    public BLookup() {
    }

    public BLookup(String code, String name, String description, Lookup lookup) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.lookup = lookup;
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

    public Lookup getLookup() {
        return lookup;
    }

    public void setLookup(Lookup lookup) {
        this.lookup = lookup;
    }
}
