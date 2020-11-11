package com.ithillel.persistence.entity.util;

import javax.persistence.AttributeConverter;
import java.util.Calendar;
import java.util.Objects;

public class CustomLongTimeConverter implements AttributeConverter<Long, Calendar> {


    @Override
    public Calendar convertToDatabaseColumn(Long aLong) {
        if (Objects.isNull(aLong)) return null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(aLong);
        return calendar;
    }

    @Override
    public Long convertToEntityAttribute(Calendar calendar) {
        if (Objects.isNull(calendar)) return null;
        return calendar.getTimeInMillis();
    }
}
