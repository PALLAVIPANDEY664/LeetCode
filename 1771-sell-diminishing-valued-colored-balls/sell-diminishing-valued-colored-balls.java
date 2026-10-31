
import java.util.*;

class Solution {

    public int maxProfit(int[] inventory, int orders) {

        Arrays.sort(inventory);

        long profit = 0;
        long mod = 1000000007;

        int n = inventory.length;

        for (int i = n - 1; i >= 0; i--) {

            long current = inventory[i];

            long next = (i == 0) ? 0 : inventory[i - 1];

            long count = n - i;

            long balls = (current - next) * count;

            if (orders >= balls) {

                profit += count *
                    (current * (current + 1) / 2 -
                    next * (next + 1) / 2);

                orders -= balls;

            } else {

                long full = orders / count;
                long remainder = orders % count;

                long low = current - full;

                profit += count *
                    (current * (current + 1) / 2 -
                    low * (low + 1) / 2);

                profit += remainder * low;

                orders = 0;
                break;
            }

            profit %= mod;
        }

        return (int)(profit % mod);
    }
}
