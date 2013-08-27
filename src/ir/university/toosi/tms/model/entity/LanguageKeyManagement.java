package ir.university.toosi.tms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

@JsonIgnoreProperties(value = "@id")
public class LanguageKeyManagement extends BaseEntity {

    @JsonProperty
    private long id;
    @JsonProperty
    private String descriptionKey;
    @JsonProperty
    private Set<LanguageManagement> languageManagements;


    public LanguageKeyManagement(String descriptionKey, Set<LanguageManagement> languageManagements) {
        this.descriptionKey = descriptionKey;
        this.languageManagements = languageManagements;
    }

    public LanguageKeyManagement(Set<LanguageManagement> languageManagements) {
        this.languageManagements = languageManagements;
    }

    public LanguageKeyManagement() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescriptionKey() {
        return descriptionKey;
    }

    public void setDescriptionKey(String descriptionKey) {
        this.descriptionKey = descriptionKey;
    }

    public Set<LanguageManagement> getLanguageManagements() {
        return languageManagements;
    }

    public void setLanguageManagements(Set<LanguageManagement> languageManagements) {
        this.languageManagements = languageManagements;
    }
}
