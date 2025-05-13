package core_java.theory;

public class Instanceof {


    static class Animal {}
    static class Dog extends Animal {}

    public static void main(String[] args) {
        Long a = 10L;
        System.out.println(a.getClass()  == Long.class);

        System.out.println(a instanceof Long);
        System.out.println(a instanceof Number);
        System.out.println(a instanceof Object);

        Animal b = new Dog();

        System.out.println(b instanceof Dog);     // true
        System.out.println(b instanceof Animal);  // true
        System.out.println(b instanceof Object);  // true
//        System.out.println(b instanceof String);  // false (sai kiểu)

        String s = null;
        System.out.println(s instanceof String); // false
    }
}
