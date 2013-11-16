package ir.university.toosi.tms.model.entity.personnel;

import ir.university.toosi.tms.util.ThreadPoolManager;

public enum PersonSearchItems {

    NAME, LASTNAME, NATIONALCODE, PERSONNELNO;

    public String getDescription() {

        switch (this) {
            case NAME:
                return ThreadPoolManager.getLangValue("NAME");
            case LASTNAME:
                return ThreadPoolManager.getLangValue("LAST_NAME");
            case NATIONALCODE:
                return ThreadPoolManager.getLangValue("NATIONAL_CODE");
            case PERSONNELNO:
                return ThreadPoolManager.getLangValue("PERSONNEL_NO");
        }
        return "";
    }

    public String getValue() {

        switch (this) {
            case NAME:
                return "1";
            case LASTNAME:
                return "2";
            case NATIONALCODE:
                return "3";
            case PERSONNELNO:
                return "4";
        }

        return "0";
    }
}
