package AnnotationPersons;

import AnnotationAutors.Autors;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Autors autors = new Autors();
        Class<?> clazz = Person.class;
        System.out.println("Klasse: " + clazz);
        Constructor<?>[] uga = clazz.getConstructors();
        Arrays.stream(uga).forEach(x-> System.out.println("Konstruktoren: "+ x));
        for (Constructor<?> con:uga) {
            java.lang.annotation.Annotation[] tobias = con.getAnnotations();
            for (Annotation ano:tobias) {
                if (ano.annotationType() == ConstructorAnnotation.class){
                    ConstructorAnnotation freddy = (ConstructorAnnotation) ano;
                    String [] hansPeter = freddy.personNames();
                    int [] handRuedi = freddy.personAges();
                    for (int i = 0; i < hansPeter.length; i++) {
                        System.out.println("Nme new Person: " + hansPeter[i] + "   New Persons Aga: " + handRuedi[i]);
                        try {
                            Person person = (Person) con.newInstance(hansPeter[i], handRuedi[i]);
                            System.out.println("Person got created\n");
                        } catch (InstantiationException e) {
                            throw new RuntimeException(e);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
