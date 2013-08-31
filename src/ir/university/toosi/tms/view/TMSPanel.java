package ir.university.toosi.tms.view;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.Languages;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 1.0
 */
public class TMSPanel extends JPanel {

    private List<Languages> languagesList;

    @Override
    public ComponentOrientation getComponentOrientation() {
        if (ThreadPoolManager.currentLanguage == null) {
            WebServiceInfo loginService = new WebServiceInfo();
            loginService.setServiceName("/getAllLanguage");
            try {
                languagesList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(loginService.getServerUrl(), loginService.getServiceName()), new TypeReference<List<Languages>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Languages languages : languagesList) {
                if (languages.isDefaulted()) {
                    ThreadPoolManager.currentLanguage = languages;
                }
            }
        }

        if (ThreadPoolManager.currentLanguage.isRtl()) {
            return ComponentOrientation.RIGHT_TO_LEFT;
        } else {
            return ComponentOrientation.LEFT_TO_RIGHT;
        }

    }
}
