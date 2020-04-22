import com.sun.corba.se.impl.oa.poa.POAPolicyMediatorImpl_NR_UDS;

import java.util.Arrays;

public class Solution39 {
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array.length <= 0) {
            return 0;
        }
        Arrays.sort(array);
        int count = 0;
        int midNum = array[array.length / 2];
        for (int i : array) {
            if (i == midNum) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return midNum;
        }
        return 0;
    }

    /**
     * 多数投票问题，可以利用Boyer-Moore Majority Vote Algorithm来解决这个问题，使得时间复杂度为O(N).
     * 使用count来统计一个元素在数组中出现的次数，当遍历到的元素和统计元素相等时，令count++,否则令count--。
     * 如果前面查找了i个元素，且count==0，说明前i个元素中没有majority，或者有majority，但是出现的次数少于
     * i/2，因为如果多i/2的话count就一定不会等于0.此时剩下的n-i个元素中，majority的数目依然多余(n-i)/2，
     * 因此继续查找就能找出majority。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution2(int[] array) {
        int majority = array[0];
        for (int i = 1, count = 1; i < array.length; i++) {
            count = array[i] == majority ? count++ : count--;
            if (count == 0) {
                majority = array[i];
                count = 1;
            }
        }
        int count = 0;
        for (int i : array) {
            if (i == majority) {
                count++;
            }
        }
        return count > array.length / 2 ? majority : 0;
    }
}
