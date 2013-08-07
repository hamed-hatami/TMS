package ir.university.toosi.tms.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Transient;
import java.io.Serializable;


public class BaseEntity implements Serializable {

    @JsonProperty
    private String effectorUser;

    public String getEffectorUser() {
        return effectorUser;
    }

    public void setEffectorUser(String effectorUser) {
        this.effectorUser = effectorUser;
    }
}
