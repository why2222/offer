

public class Solution11 {
    public static int minNumberInRotateArray(int[] array) {
        int min = 0;
        if (array.length == 0) {
            return min;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                min = array[i + 1];
                return min;
            }
        }
        return min;
    }

    /*
    二分查找法
     */
    public static int minNumberInRotateArray2(int[] array) {
        int head = 0;
        int tail = array.length - 1;
        int min = head;
        int mid;
        if (array.length == 0) {
            return min;
        }
        while (array[head] >= array[tail]) {
            mid = (tail + head + 1) / 2;
            if (tail - head == 1) {
                min = array[tail];
                break;
            }
            if (array[head] >= array[mid]) {
                tail = mid;
            } else {
                head = mid;
            }
        }
        return min;
    }
}
