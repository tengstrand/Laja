package net.sf.laja.cdd.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface State {
    public int version() default 1;
    public String type() default "immutable";
}
