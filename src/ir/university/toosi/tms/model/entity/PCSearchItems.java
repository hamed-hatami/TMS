package ir.university.toosi.tms.model.entity;

public enum PCSearchItems {

    NAME, IP;

    public String getDescription() {

        switch (this) {
            case NAME:
                return "Name";
            case IP:
                return "ip";
        }
        return "";
    }

    public String getValue() {

        switch (this) {
            case NAME:
                return "1";
            case IP:
                return "2";
        }

        return "0";
    }
}
