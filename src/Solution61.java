import java.util.Arrays;

public class Solution61 {
    public static boolean isContinuous(int [] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        int cntZero = 0;
        int start = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                cntZero++;
                start++;
            } else {
                break;
            }
        }
        int gap = 0;
        for (int i = start + 1; i < numbers.length; i++) {
            if (i > start && numbers[i] == numbers[i - 1]) {
                return false;
            }
            if (numbers[i] != 0 && i >= start + 1) {
                gap += numbers[i] - numbers[i - 1] - 1;
            }
        }
        return gap > cntZero ? false : true;
    }
}
