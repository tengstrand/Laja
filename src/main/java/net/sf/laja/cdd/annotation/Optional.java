package net.sf.laja.cdd.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Optional {
    public String defaultValue() default "*";
}
