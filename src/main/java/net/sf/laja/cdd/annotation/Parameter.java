package net.sf.laja.cdd.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Parameter {
    public String attribute();
    public String nextAttribute() default "";
    public String method() default "";
    public String methodSignature() default "";
    public String value() default "";
    public boolean suppressOriginal() default false;
}
