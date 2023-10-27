package AnnotationAutors;

import lombok.Getter;

@Annotation(autors ={ "Nevio"}, beschreibung = "Test", version = "0.00e")
public class Autors {
        private String[] autors;
        private String beschreibung;
        private String version;

}
