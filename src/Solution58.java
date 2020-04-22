public class Solution58 {
    public static String ReverseSentence(String str) {
        char[] str_arr = str.toCharArray();
        int phase = str.length();
        String res = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str_arr[i] == ' ') {
                res += str.substring(i + 1,phase);
                res += " ";
                phase = i;
            }
        }
        return res + str.substring(0,phase);
    }
}
