import java.util.List;
import java.util.Set;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> result = new java.util.ArrayList<>();
        List<Integer> sortedCoins = new java.util.ArrayList<>(coins);
        sortedCoins.sort(java.util.Collections.reverseOrder());

        for (int coin : sortedCoins) {
            while (amount >= coin) {
                amount -= coin;
                result.add(coin);
            }
        }
        return result;
    }
}