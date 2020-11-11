package com.ithillel.persistence.entity.util;

import javax.persistence.AttributeConverter;

public class CustomKeyConverter implements AttributeConverter<String, String> {
    KeyCreator keyCreator = new KeyCreator();

    public CustomKeyConverter() throws Exception {
    }

    @Override
    public String convertToDatabaseColumn(String s) {
        return keyCreator.encrypt(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return keyCreator.decrypt(s);
    }


}
