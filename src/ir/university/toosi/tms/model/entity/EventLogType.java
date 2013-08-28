package ir.university.toosi.tms.model.entity;


import ir.university.toosi.tms.util.ThreadPoolManager;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

public enum EventLogType {

    ADD, EDIT, DELETE, SEARCH;

    public String getDescription() {

        switch (this) {

            case ADD:
                return ThreadPoolManager.getLangValue("TMS_ADD");
            case EDIT:
                return ThreadPoolManager.getLangValue("TMS_EDIT");
            case DELETE:
                return ThreadPoolManager.getLangValue("TMS_DELETE");
            case SEARCH:
                return ThreadPoolManager.getLangValue("TMS_SEARCH");
        }
        return "NONE";
    }

    public String getValue() {
        switch (this) {

            case ADD:
                return "1";
            case EDIT:
                return "2";
            case DELETE:
                return "3";
            case SEARCH:
                return "4";
        }
        return "0";
    }
}