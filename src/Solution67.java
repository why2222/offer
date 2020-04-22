public class Solution67 {
    // status为0时，str有效，status为1时，str无效
    private static int status = 0;

    public static int StrToInt(String str) {
        char[] chars = str.toCharArray();
        if (chars.length < 1) {
            return 0;
        }
        long res = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                status = 1;
                return 0;
            }
            res += (chars[i] - '0') * (int) Math.pow(10, chars.length - i - 1);
        }
        if (chars[0] == '+') {
            return checkInt(res) ? (int) res : 0;
        } else if (chars[0] == '-') {
            return checkInt(-res) ? (int) -res : 0;
        } else if (chars[0] > '0' && chars[0] < '9') {
            res += (chars[0] - '0') * (int) Math.pow(10, chars.length - 1);
        } else {
            status = 1;
            return 0;
        }
        return checkInt(res) ? (int) res : 0;
    }

    private static boolean checkInt(long num) {
        if (num >= -2147483648 && num <= 2147483647) {
            return true;
        } else {
            status = 1;
            return false;
        }
    }
}
