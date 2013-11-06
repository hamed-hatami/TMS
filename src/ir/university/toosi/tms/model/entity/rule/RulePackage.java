package ir.university.toosi.tms.model.entity.rule;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.university.toosi.tms.model.entity.BaseEntity;
import ir.university.toosi.tms.model.entity.calendar.Calendar;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */
@Entity
@Table(name = "tb_RulePackage")
@NamedQueries({
        @NamedQuery(
                name = "RulePackage.list",
                query = "select r from RulePackage r where r.deleted='0' "
        ),
        @NamedQuery(
                name = "RulePackage.findById",
                query = "select r from RulePackage r where r.id=:id"

        ), @NamedQuery(
        name = "RulePackage.maximum",
        query = "select max(r.id) from RulePackage r"
)
})
public class RulePackage extends BaseEntity {

    @Id
    @JsonProperty
    @Column(name = "id")
    private long id;
    @JsonProperty
    @Column(name = "name")
    private String name;
    @JsonProperty
    @ManyToOne
    private Calendar calendar;
    @OneToMany(fetch = FetchType.EAGER)
    @JsonProperty
    private Set<Rule> rules = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER)
    @JsonProperty
    private Set<RuleException> ruleExceptions = new HashSet<>();
    @JsonProperty
    @Column(name = "aniPassBack")
    private boolean aniPassBack;
    @JsonProperty
    @Column(name = "allowExit")
    private boolean allowExit;
    @JsonProperty
    @Column(name = "allowExitGadget")
    private boolean allowExitGadget;

    public RulePackage() {
    }

    public RulePackage(long id, String name, Calendar calendar, Set<Rule> rules, Set<RuleException> ruleExceptions, boolean aniPassBack, boolean allowExit, boolean allowExitGadget) {
        this.id = id;
        this.name = name;
        this.calendar = calendar;
        this.rules = rules;
        this.ruleExceptions = ruleExceptions;
        this.aniPassBack = aniPassBack;
        this.allowExit = allowExit;
        this.allowExitGadget = allowExitGadget;
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

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Set<Rule> getRules() {
        return rules;
    }

    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }

    public Set<RuleException> getRuleExceptions() {
        return ruleExceptions;
    }

    public void setRuleExceptions(Set<RuleException> ruleExceptions) {
        this.ruleExceptions = ruleExceptions;
    }

    public boolean isAniPassBack() {
        return aniPassBack;
    }

    public void setAniPassBack(boolean aniPassBack) {
        this.aniPassBack = aniPassBack;
    }

    public boolean isAllowExit() {
        return allowExit;
    }

    public void setAllowExit(boolean allowExit) {
        this.allowExit = allowExit;
    }

    public boolean isAllowExitGadget() {
        return allowExitGadget;
    }

    public void setAllowExitGadget(boolean allowExitGadget) {
        this.allowExitGadget = allowExitGadget;
    }
}