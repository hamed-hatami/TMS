package ir.university.toosi.tms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(value = "@id")
public class Lookup extends BaseEntity {


    @JsonProperty
    private long id;

    @JsonProperty
    private String title;

    @JsonProperty
    private boolean definable;

    @JsonProperty
    private String titleText;



    public Lookup() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public boolean isDefinable() {
        return definable;
    }

    public void setDefinable(boolean definable) {
        this.definable = definable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }
}
