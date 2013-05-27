package net.sf.laja.cdd.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ImmutableType {
    public Class type();
    public String value() default "*";
}
