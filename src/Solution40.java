import java.util.ArrayList;
import java.util.Arrays;

public class Solution40 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length <= 0 || input.length < k) {
            return result;
        }
        Arrays.sort(input);
        int count = 0;
        while (count < k) {
            result.add(input[count]);
            count++;
        }
        return result;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length <= 0 || input.length < k || k < 0) {
            return result;
        }
        findKthSmallest(input, k - 1);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    public static void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            }
            if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
    }

    /**
     * 选择一个数字，比选择数字小的放在左边，比选择数字大的放在右边
     * @param nums
     * @param l start
     * @param h end
     * @return
     */
    public static int partition(int[] nums, int l, int h) {
        int p = nums[l];    // p为基准值
        int i = l;
        int j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p) ;   // 筛选出大于p的数值
            while (j != l && nums[--j] > p) ;   // 筛选出小于p的数值
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
