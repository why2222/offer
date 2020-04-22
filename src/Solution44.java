public class Solution44 {
    public int getDigitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int digits = 1; // 1:个位；2：十位。。。
        while (true) {
            int amount = getAmountOfDigits(digits);
            int totalAmount = amount * digits;
            if (index < totalAmount) {
                return getDigitAtIndex(index, digits);
            }
            index -= totalAmount;
            digits++;
        }
    }

    private int getAmountOfDigits(int digits) {
        if (digits == 1) {
            return 10;
        }
        return (int) Math.pow(10, digits - 1) * 9;
    }

    private int getBeginNumberOfDigits(int digits) {
        if (digits == 1) {
            return 0;
        }
        return (int) Math.pow(10, digits - 1);
    }

    // 理解！！！
    private int getDigitAtIndex(int index, int digits) {
        int beginNumber = getBeginNumberOfDigits(digits);
        int shiftNumber = index / digits;
        String number = (beginNumber + shiftNumber) + "";
        int count = index % digits;
        return number.charAt(count) - '0';
    }

}
