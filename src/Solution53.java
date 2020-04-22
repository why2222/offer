public class Solution53 {
    public int GetNumberOfK(int [] array , int k) {
        int res = 0;
        for (int num : array) {
            if (num == k) {
                res++;
            }
        }
        return res;
    }

    public static int GetNumberOfK2(int [] array , int k) {
        int target = binarySearch(array, k);
        int next = binarySearch(array, k + 1);
        return (target == array.length || array[target] != k) ? 0 : next - target;
    }

    public static int binarySearch(int[] array, int k) {
        int l = 0;
        // 如果这里是array.length；
        // 当数组最后一位的值为k时，由于下方判断条件(l<r),将无法把最后一位计算在内，会导致结果减1。
        int r = array.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (k <= array[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
