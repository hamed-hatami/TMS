package ir.university.toosi.tms.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Transient;
import java.io.Serializable;


public class BaseEntity implements Serializable {

    @JsonProperty
    private String effectorUser;
    @JsonProperty
    protected String deleted;
    @JsonProperty
    protected String status;

    public String getEffectorUser() {
        return effectorUser;
    }

    public void setEffectorUser(String effectorUser) {
        this.effectorUser = effectorUser;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
