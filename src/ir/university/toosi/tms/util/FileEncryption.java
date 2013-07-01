package ir.university.toosi.tms.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi, Mostafa Rastgar
 * @version : 0.8
 */

public class FileEncryption {

    private PublicKey publicKey = null;

    public void saveKey(String out, String publicKeyFile) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            Path path = Paths.get(publicKeyFile);
            X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(Files.newInputStream(path));
            publicKey = certificate.getPublicKey();
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
            FileOutputStream fileOutputStream = new FileOutputStream(out);
            fileOutputStream.write(x509EncodedKeySpec.getEncoded());
            fileOutputStream.close();

        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadKey(String publicKeyFile) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Path path = Paths.get(publicKeyFile);
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Files.readAllBytes(path));
            publicKey = keyFactory.generatePublic(publicKeySpec);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    public void encrypt(String output, String input) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            Path path = Paths.get(input);
            byte[] encValue = cipher.doFinal(Files.readAllBytes(path));

            FileOutputStream fileOutputStream = new FileOutputStream(output);
            fileOutputStream.write(encValue);
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decrypt(String output, String input) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, publicKey);

            Path path = Paths.get(input);
            byte[] decValue = cipher.doFinal(Files.readAllBytes(path));

            FileOutputStream fileOutputStream = new FileOutputStream(output);
            fileOutputStream.write(decValue);
            fileOutputStream.close();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}