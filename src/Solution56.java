import sun.util.resources.cldr.ta.CurrencyNames_ta;

public class Solution56 {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length <= 0 || array == null) {
            return;
        }
        int[] temp = new int[3];
        int cnt = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[j] == array[i]) {
                    break;
                } else if (j == array.length - 1 && array[j] != array[i]) {
                    temp[cnt] = array[i];
                    cnt++;
                } else if (j == array.length - 1 && i == j) {
                    temp[cnt] = array[i];
                    cnt++;
                }
            }
        }
        num1[0] = temp[0];
        num2[0] = temp[1];
    }

    public static void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        int diff = 0;
        for (int i : array) {
            diff ^= i;
        }
        diff &= -diff;
        for (int i : array) {
            if ((diff & i) == diff) {
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }
        }
    }
}
