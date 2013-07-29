package ir.university.toosi.tms.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;


public class Language implements Serializable {

    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private boolean rtl;
    @JsonProperty
    private byte[] content;

    public Language() {
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public boolean isRtl() {
        return rtl;
    }

    public void setRtl(boolean rtl) {
        this.rtl = rtl;
    }
}
