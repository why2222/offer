public class Solution14 {
    /**
     * 动态规划
     * @param target
     * @return
     */
    public int cutRope(int target) {
        int[] product = new int[target + 1];    // 构造数组，来存储每一个子集最优解
        product[1] = 1;
        for (int i = 2; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                product[i] = Math.max(product[i], Math.max(j * (i - j), product[j] * (i - j)));
            }
        }
        return product[target];
    }

    /**
     * 贪婪算法
     * 尽可能多剪长度为3的绳子，并且不允许有长度为1的绳子出现。
     * 如果出现了，就从已经切好的长度为3的绳子中拿出一段与长度为1的绳子重新组合，把他们切成两段为2的绳子。
     * @param target
     * @return
     */
    public int cutRope2(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int timesOf3 = target / 3;
        if (target % timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (target - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }
}
