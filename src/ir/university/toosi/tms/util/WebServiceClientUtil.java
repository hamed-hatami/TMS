package ir.university.toosi.tms.util;

import ir.university.toosi.tms.model.entity.User;
import ir.university.toosi.tms.model.service.UserService;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import javax.net.ssl.*;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceFactory;
import java.net.URL;


public class WebServiceClientUtil {

    private static String nameSpace = "http://service.model.tms.toosi.university.ir/";
    private static String serviceName = "UserService";

    public static boolean authentication(String wsdlUrl, String[] parameters) {
        try {

            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }
                    }
            };

            SSLContext context = SSLContext.getInstance("SSL");
            context.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());

            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            ServiceFactory factory = ServiceFactory.newInstance();
            Service service = factory.createService(new URL(wsdlUrl), new javax.xml.namespace.QName(nameSpace, serviceName));
            //Service service = Service.create(new URL(wsdlUrl), new javax.xml.namespace.QName(nameSpace, serviceName));
            UserService userService = (UserService) service.getPort(UserService.class);
            Client client = ClientProxy.getClient(userService);
            if (client != null) {
                HTTPConduit conduit = (HTTPConduit) client.getConduit();
                TLSClientParameters tlsClientParameters = new TLSClientParameters();
                tlsClientParameters.setTrustManagers(trustAllCerts);
                tlsClientParameters.setDisableCNCheck(true);
                conduit.setTlsClientParameters(tlsClientParameters);
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(0);
                policy.setReceiveTimeout(0);
                policy.setAllowChunking(false);
                conduit.setClient(policy);
            }
            userService.authenticate(parameters[0], parameters[1]);
/*
            if (user != null) {
                return true;
            } else {
                return false;
            }
*/
        } catch (Exception e) {
            return false;
        }
      return false;
    }

}
