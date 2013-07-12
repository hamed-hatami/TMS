package ir.university.toosi.tms.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi, Mostafa Rastgar
 * @version : 0.8
 */

public class RESTfulClientUtil {

    public User authenticateService(String url, String serviceName, String jsonString) {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(url + serviceName);
            postRequest.setHeader("Content-type", "application/json");
            postRequest.setEntity(new StringEntity(jsonString));
            HttpResponse response = client.execute(postRequest);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            User user = new ObjectMapper().readValue(response.getEntity().getContent(), User.class);
            System.out.println("USER : " + user);
            client.getConnectionManager().shutdown();
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