import java.util.ArrayList;

public class Solution59 {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || size < 1) {
            return res;
        }
        for (int i = 0; i < num.length; i++) {
            if (size == 1) {
                res.add(num[i]);
            } else if (i + size - 1 < num.length) {
                int max = 0;
                for (int j = i; j < i + size - 1; j++) {
                    max = Math.max(max, Math.max(num[j], num[j + 1]));
                }
                res.add(max);
            }
        }
        return res;
    }
}
