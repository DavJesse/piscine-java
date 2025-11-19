import java.util.Map;
import java.util.Set;

public class WeddingComplex {
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        java.util.List<String> firstList = new java.util.ArrayList<>(first);
        java.util.List<String> secondList = new java.util.ArrayList<>(second);
        java.util.Collections.shuffle(firstList);
        java.util.Collections.shuffle(secondList);

        int size = Math.min(firstList.size(), secondList.size());
        Map<String, String> couples = new java.util.HashMap<>();

        for (int i = 0; i < size; i++) {
            couples.put(firstList.get(i), secondList.get(i));
        }

        return couples;
    }
}