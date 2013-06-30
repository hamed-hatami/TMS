package ir.university.toosi.tms.util;

import ir.university.toosi.tms.model.entity.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi, Mostafa Rastgar
 * @version : 0.8
 */

public class RESTfulClientUtil {

    public static User authenticateService(String url, String serviceName, String jsonString) {
        try {
            System.out.println("IN CLIENT");
            HttpClient client = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(url + serviceName);
            System.out.println("AFTER HTTP POST");
            postRequest.setHeader("Content-type", "application/json");
            postRequest.setEntity(new StringEntity(jsonString));
            HttpResponse response = client.execute(postRequest);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            System.out.println("AFTER RESPONSE");

//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader((response.getEntity().getContent())));
//
//            String result = "";
//            String output = "";
//            while ((output = br.readLine()) != null) {
//                result += output;
//            }
//
//            client.getConnectionManager().shutdown();
//            System.out.println(result);
            User user = new ObjectMapper().readValue(response.getEntity().getContent(), User.class);
            System.out.println("USER : " + user);
            return user;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String callInitialService() {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(Configuration.getProperty("processor_url") + "initial");
            HttpResponse response = client.execute(postRequest);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String result = "";
            String output = "";
            while ((output = br.readLine()) != null) {
                result += output;
            }

            client.getConnectionManager().shutdown();

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}