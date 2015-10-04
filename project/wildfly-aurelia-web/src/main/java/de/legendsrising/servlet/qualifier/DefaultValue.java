package de.legendsrising.servlet.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

@Target({TYPE, METHOD, PARAMETER, FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultValue
{
    public String value();
}