package core_java.theory;

import java.util.Arrays;

public class StringNote {
    public static void main(java.lang.String[] args) {
        String note = "Hello world";

        System.out.println(note.length());

        System.out.println(note.charAt(0));

        System.out.println(note.substring(1,4));

        System.out.println(note.indexOf("world"));

        System.out.println(note.replace("world","mom"));

        System.out.println(note.split(" ").toString());
        System.out.println(Arrays.toString(note.split(" ")));

        System.out.println(note.toUpperCase());

        System.out.println(note.toLowerCase());
    }


}
