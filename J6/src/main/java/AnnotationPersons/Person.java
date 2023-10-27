package AnnotationPersons;
@PersonAnnotation()
public class Person {
    private String name;
    private int age;
    @ConstructorAnnotation(personNames = {"uga","ug","u"},personAges = {1,2,3})
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String getNameToString(){
        return name = toString();
    }
}
