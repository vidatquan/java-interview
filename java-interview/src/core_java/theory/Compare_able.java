package core_java.theory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Compare_able {

    public static class Person implements Comparable<Person> {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.age, o.age);
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 20)
        );

        Collections.sort(people);
        System.out.println(people);
    }
}
