public class Solution20 {
    public static boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
