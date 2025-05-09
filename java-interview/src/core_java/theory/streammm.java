package core_java.theory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class streammm {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        numbers.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

        numbers.stream().map(x -> x * x).forEach(System.out::println);

        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
        nestedList.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        List<Integer> duplicates = Arrays.asList(1, 2, 2, 3);
        duplicates.stream()
                .distinct()
                .forEach(System.out::println);

        numbers.stream()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);


    }
}
