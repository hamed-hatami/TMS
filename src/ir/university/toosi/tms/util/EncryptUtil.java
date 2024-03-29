package ir.university.toosi.tms.util;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;


/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */
public class EncryptUtil {

    private static final String ALGORITHM = "AES";
    private static final int ITERATIONS = 2;
    private static final byte[] keyValue = new byte[]{'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
    private static final String salt = "this is a simple clear salt";

    public String encrypt(String value) {
        String eValue = null;
        try {
            Key key = generateKey();
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, key);

            String valueToEnc = null;
            eValue = value;
            for (int i = 0; i < ITERATIONS; i++) {
                valueToEnc = salt + eValue;
                byte[] encValue = c.doFinal(valueToEnc.getBytes());
                eValue = org.apache.commons.codec.binary.Base64.encodeBase64String(encValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (eValue.contains("\r"))
            eValue = eValue.replace("\r", "");
        return eValue;
    }

    public String decrypt(String value) {
        String dValue = null;
        try {
            Key key = generateKey();
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, key);

            dValue = null;
            String valueToDecrypt = value;
            for (int i = 0; i < ITERATIONS; i++) {
                byte[] decordedValue = org.apache.commons.codec.binary.Base64.decodeBase64(valueToDecrypt);
                byte[] decValue = c.doFinal(decordedValue);
                dValue = new String(decValue).substring(salt.length());
                valueToDecrypt = dValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dValue;
    }

    private Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }

}