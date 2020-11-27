package com.ithillel.persistence.entity.util;

import com.ithillel.persistence.entity.ClientEntity;
import com.ithillel.persistence.entity.service.interfaces.ClientService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.spec.KeySpec;

public class KeyCreator {

    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private final Cipher cipher;
    byte[] arrayBytes;
    SecretKey key;

    public KeyCreator() throws Exception {
        String myEncryptionKey = "NumberShouldBeMoreThen24Digits";
        String myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        KeySpec ks = new DESedeKeySpec(arrayBytes);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = skf.generateSecret(ks);
    }


    public String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }


    public String decrypt(String encryptedString) {
        String decryptedText = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText = new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }


    public static void main(String args []) throws Exception
    {
        KeyCreator keyCreator= new KeyCreator();

        String target = "Vasiliy Ermakov";
        String encrypted = keyCreator.encrypt(target);
        String decrypted = keyCreator.decrypt(encrypted);

        System.out.println("String To Encrypt: "+ target);
        System.out.println("Encrypted String: " + encrypted);
        System.out.println("Decrypted String: " + decrypted);

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring/default-beans.xml");
        ClientService clientService = (ClientService) context.getBean("clientServiceImpl");
        ClientEntity entity = clientService.getById(10);
        entity.setPassword("password1");
        System.out.println("not updated entity|||" + entity.getPassword());
        clientService.update(entity);
        System.out.println("password1|||" + clientService.getById(10).getPassword());
        clientService.changePasswordById(10, "password2");
        System.out.println("password2|||" + clientService.getById(10).getPassword());

    }
}
