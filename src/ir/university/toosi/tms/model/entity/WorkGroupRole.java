package ir.university.toosi.tms.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
@JsonIgnoreProperties(value = "@id")
public class WorkGroupRole {

    private long id;
    private WorkGroup workgroup;
    private Role role;

    public WorkGroupRole() {
    }
    public WorkGroupRole(int id) {
    }

    public WorkGroupRole(long id, WorkGroup workgroup, Role role) {
        this.id = id;
        this.workgroup = workgroup;
        this.role = role;
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
