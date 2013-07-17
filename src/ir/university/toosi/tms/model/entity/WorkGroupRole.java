package ir.university.toosi.tms.model.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

public class WorkGroupRole {

    private long id;
    private WorkGroup workgroup;
    private Role role;

    public WorkGroupRole() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WorkGroup getWorkgroup() {
        return workgroup;
    }

    public void setWorkgroup(WorkGroup workgroup) {
        this.workgroup = workgroup;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
