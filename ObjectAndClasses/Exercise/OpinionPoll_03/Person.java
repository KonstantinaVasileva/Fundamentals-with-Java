package ObjectsAndClasses_Exercises.OpinionPoll_03;

public class Person {
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
