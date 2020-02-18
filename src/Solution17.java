import sun.security.util.Length;

public class Solution17 {
    public static void Print1ToMaxOfDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        IntToChar(number,0);
    }

    /**
     * 考虑到大数，使用char数组存储int类型
     * @param number
     * @param digit
     */
    private static void IntToChar(char[] number, int digit) {
        if (digit == number.length) {
            PrintNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            IntToChar(number, digit + 1);
        }
    }

    private static void PrintNumber(char [] number) {
        int index = 0;
        while (index < number.length && number[index] == '0') {
            index++;
        }
        while (index < number.length) {
            System.out.print(number[index++]);
        }
        System.out.println();
    }
}
