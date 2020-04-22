public class Solution43 {
    public int NumberOf1Between1AndN_Solution(int n){
        if (n == 0) {
            return 0;
        }
        String nStr = "" + n;
        int nLength = nStr.length();
        if (nLength == 1) {
            return 1;
        }
        int res = (int) Math.pow(10, nLength - 1);
        int firstNum = n / res;
        int firstBit = firstNum == 1 ? (n % res) + 1 : res;
        int otherBit = (nLength - 1) * firstNum * res / 10;
        return firstBit + otherBit + NumberOf1Between1AndN_Solution(n % res);
    }
}
