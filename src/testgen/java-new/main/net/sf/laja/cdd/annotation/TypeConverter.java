package net.sf.laja.cdd.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TypeConverter {
    public Class[] behaviours() default All.class;

    static class All {}
}
