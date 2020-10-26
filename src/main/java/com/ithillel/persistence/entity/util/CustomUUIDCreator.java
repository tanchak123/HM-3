package com.ithillel.persistence.entity.util;

import org.hibernate.annotations.ValueGenerationType;
import org.hibernate.tuple.CreationTimestampGeneration;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

@ValueGenerationType(generatedBy = CustomUUIDCreatorGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ FIELD, METHOD })
public @interface CustomUUIDCreator {
}
