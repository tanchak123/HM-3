package com.ithillel.persistence.entity.util;

import javax.crypto.SecretKey;
import javax.persistence.AttributeConverter;
import java.util.Arrays;

public class PassWordKeyCreator implements AttributeConverter<String, String> {
    private final SecretKey secretKey = AESKeyCreator.getAESKey(EncryptoAES.AES_KEY_BIT);
    byte[] iv = AESKeyCreator.getRandomNonce(EncryptoAES.IV_LENGTH_BYTE);

    public PassWordKeyCreator() throws Exception {
    }

    @Override
    public String convertToDatabaseColumn(String s) {
        try {
            byte[] encryptedText = EncryptoAES.encryptWithPrefixIV(
                    s.getBytes(EncryptoAES.UTF_8), secretKey, iv);
            s = AESKeyCreator.hex(encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return s;
    }
}
