public class Solution21 {
    /**
     * 没有保证调整后的数组，奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public static void reOrderArray(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            if (isEven(array[i])) {
                temp = array[i];
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = temp;
            }
        }
    }

    /**
     * 保证调整之后的数组，奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public static void reOrderArray2(int[] array) {
        int odd_count = 0;
        int even_count = 0;
        int[] odd = new int[array.length];
        int[] even= new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (isEven(array[i])) {
                even[even_count] = array[i];
                even_count++;
            } else {
                odd[odd_count] = array[i];
                odd_count++;
            }
        }
        for (int i = odd_count; i < array.length; i++) {
            odd[i] = even[i - odd_count];
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = odd[i];
        }
    }

    /**
     * 使用冒泡思想，每次都当前偶数上浮到当前最右边。时间复杂度O(N^2),空间复杂度O(1),时间换空间。
     * @param array
     */
    public static void reOrderArray3(int[] array) {
        int n = array.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isEven(array[j]) && !isEven(array[j + 1])) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
