package net.sf.laja.cdd.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Parameter {
    public String name();
    public String methodName() default "";
    public String methodSignature() default "";
    public String assignment() default "";
    public String[] statements() default {};
    public String nextAttribute() default "";
}
