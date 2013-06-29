package net.sf.laja.cdd.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Parameter {
    public String name();
    public String next() default "";
    public String method() default "";
    public String signature() default "";
    public String value() default "";
}
