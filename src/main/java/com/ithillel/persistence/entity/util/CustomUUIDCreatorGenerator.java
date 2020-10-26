package com.ithillel.persistence.entity.util;

import org.hibernate.Session;
import org.hibernate.tuple.AnnotationValueGeneration;
import org.hibernate.tuple.GenerationTiming;
import org.hibernate.tuple.ValueGenerator;

import java.util.UUID;

public class CustomUUIDCreatorGenerator implements AnnotationValueGeneration<CustomUUIDCreator> {
    @Override
    public void initialize(CustomUUIDCreator annotation, Class<?> propertyType) {

    }

    @Override
    public GenerationTiming getGenerationTiming() {
        return GenerationTiming.INSERT;
    }

    @Override
    public ValueGenerator<?> getValueGenerator() {
       /* ValueGenerator valueGenerator = new ValueGenerator() {
            @Override
            public Object generateValue(Session session, Object owner) {
                return UUID.randomUUID().toString();
            }
        }*/
        return null;//(session, owner) -> UUID.randomUUID().toString();
    }

    @Override
    public boolean referenceColumnInSql() {
        return true;
    }

    @Override
    public String getDatabaseGeneratedReferencedColumnValue() {
        return "gen_random_uuid()";
    }
}
