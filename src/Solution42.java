public class Solution42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp = temp + array[i];
            res = res > temp ? res : temp;
            if (temp < 0) {
                temp = 0;
            }
        }
        return res;
    }
}
