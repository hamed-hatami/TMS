package ir.university.toosi.tms.model.entity.zone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BLookup;
import ir.university.toosi.tms.model.entity.BaseEntity;

import javax.persistence.*;

@JsonIgnoreProperties(value = "@id")
public class Output extends BaseEntity {

    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private BLookup outputStatus;
    @JsonProperty
    private String delayTime;
    @JsonProperty
    private String activityTime;


    public Output() {
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

    public BLookup getOutputStatus() {
        return outputStatus;
    }

    public void setOutputStatus(BLookup outputStatus) {
        this.outputStatus = outputStatus;
    }

    public String getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(String delayTime) {
        this.delayTime = delayTime;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }
}
