public class Solution1 {
    public static String LeftRotateString(String str,int n) {
        if (str == null || str.length() < n) {
            return "";
        }
        String head = str.substring(n);
        String tail = str.substring(0, n);
        return head + tail;
    }
}
