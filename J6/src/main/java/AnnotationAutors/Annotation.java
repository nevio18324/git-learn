package AnnotationAutors;

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME) // Specify when the annotation should be available (RUNTIME or SOURCE)
@Target(ElementType.TYPE) // Specify where the annotation can be used (METHOD, CLASS, etc.)
public @interface Annotation {
    String [] autors() default {""};
    String beschreibung() default "";
    String version() default "0.0.1";
}

