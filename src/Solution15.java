public class Solution15 {
    public static int NumberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count ++;
        }
        return count;
    }
}