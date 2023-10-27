package AnnotationAutors;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("labs.Annotation")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class DocumentationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for(TypeElement annotation:annotations){
            Set<?extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
            for(Element element:annotatedElements){
                Annotation process =element.getAnnotation(Annotation.class);
                System.out.println(process.version() + process.beschreibung() + process.autors()[0]);
            }
        }
        return false;
    }
}

