public class Solution64 {

    /**
     * 1.递归
     * 2.&& 短路：只要第一个条件不满足，后面的条件就不进行判断了。(解题关键！)
     * @param n
     * @return
     */
    public static int Sum_Solution(int n) {
        int res = n;
        boolean end = n > 0 && (res += Sum_Solution(n - 1)) > 0;
        return res;
    }
}
