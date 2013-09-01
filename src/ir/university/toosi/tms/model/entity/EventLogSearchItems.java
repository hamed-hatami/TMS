package ir.university.toosi.tms.model.entity;

import ir.university.toosi.tms.util.ThreadPoolManager;

public enum EventLogSearchItems {

   /* TITLE, TYPE, DATE, TIME, USER, */TABLE;

    public String getDescription() {

        switch (this) {
//            case TITLE:
//                return ThreadPoolManager.getLangValue("TMS_TITLE");
//            case TYPE:
//                return ThreadPoolManager.getLangValue("TMS_TYPE");
//            case DATE:
//                return ThreadPoolManager.getLangValue("TMS_DATE");
            case TABLE:
                return ThreadPoolManager.getLangValue("TMS_TABLE");
//            case TIME:
//                return ThreadPoolManager.getLangValue("TMS_TIME");
//            case USER:
//                return ThreadPoolManager.getLangValue("TMS_USER");
        }
        return "";
    }

    public String getValue() {

        switch (this) {
//            case TITLE:
//                return "1";
//            case TYPE:
//                return "2";
//            case DATE:
//                return "3";
            case TABLE:
                return "4";
//            case TIME:
//                return "5";
//            case USER:
//                return "6";
        }

        return "0";
    }
}
