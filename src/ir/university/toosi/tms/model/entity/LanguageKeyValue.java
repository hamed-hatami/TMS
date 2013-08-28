package ir.university.toosi.tms.model.entity;

public class LanguageKeyValue {

    private String key;
    private String value;
    private boolean edited;


    public LanguageKeyValue() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }
}
