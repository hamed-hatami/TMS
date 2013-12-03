package ir.university.toosi.tms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = "@id")
public class BLookup extends BaseEntity {

    @JsonProperty
    private long id;

    @JsonProperty
    private String title;

    @JsonProperty
    private Lookup lookup;

    @JsonProperty
    private String titleText;


    public BLookup() {
    }

    public BLookup(long id, String title, Lookup lookup) {
        this.id = id;
        this.title = title;
        this.lookup = lookup;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Lookup getLookup() {
        return lookup;
    }

    public void setLookup(Lookup lookup) {
        this.lookup = lookup;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }
    @Override
    public String toString(){
        return title;
    }
}