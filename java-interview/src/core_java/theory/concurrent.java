package core_java.theory;

import java.util.concurrent.ConcurrentHashMap;

public class concurrent {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.computeIfPresent("A", (k, v) -> v + 1);
        System.out.println(map.get("A")); // In: 2
    }
}
