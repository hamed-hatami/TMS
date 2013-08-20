package ir.university.toosi.tms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = "@id")
public class PC extends BaseEntity {

    @JsonProperty
    private long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String ip;

    @JsonProperty
    private String location;

    public PC() {
    }

    public PC(String name, String ip, String location) {
        this.name = name;
        this.ip = ip;
        this.location = location;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
