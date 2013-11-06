package ir.university.toosi.tms.util;


public class ComboSelectItem {
    private String label;
    private Object value;

    public ComboSelectItem(String label, Object value){
        this.label = label;
        this.value = value;
    }

    public String toString(){
        return label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

