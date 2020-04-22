public class Solution50 {
    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            char present = str.charAt(i);
            for (int j = 0; j < str.length(); j++) {
                if (present == str.charAt(j) && i != j) {
                    break;
                }
                if (present != str.charAt(j) && j == str.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int FirstNotRepeatingChar2(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        int[] temp = new int[52];
        char[] chars = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            if (chars[i] <= 'z' && chars[i] >= 'a') {
                temp[chars[i] - 'a']++;
            }
            if (chars[i] <= 'Z' && chars[i] >= 'A') {
                temp[chars[i] - 'A' + 26]++;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (chars[i] <= 'z' && chars[i] >= 'a') {
                if (temp[chars[i] - 'a'] == 1) {
                    return i;
                }
            }
            if (chars[i] <= 'Z' && chars[i] >= 'A') {
                if (temp[chars[i] - 'A' + 26] == 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
