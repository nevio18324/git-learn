package AnnotationAutors;

public class Main {

    public static void main(String[] args) {
        Annotation annotation = Autors.class.getAnnotation(Annotation.class);
        System.out.println(annotation.autors()[0]+"\n"+annotation.beschreibung()+"\n"+annotation.version());
    }
}
