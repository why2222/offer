public class Solution16 {
    public static double Power(double base, int exponent) {
        double result = 1;
        if (exponent == 0) {
            return result;
        }
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result = result * base;
            }
        } else if (exponent < 0) {
            for (int i = 0; i < -exponent; i++) {
                result = result * base;
            }
            result = 1 / result;
        }
        return result;
    }

    public static double Power2(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean isNegative = false;
        if (exponent < 0) {
            isNegative = true;
            exponent = -exponent;
        }
        double pow = Power2(base, exponent >> 1); // 使用右移运算符代替除以2
        pow *= pow;
        // 用位运算代替求余运算
        if ((exponent & 0x1) == 1) {
            pow = pow * base;
        }
        return isNegative ? 1 / pow : pow;
    }
}
