/**
 * ## 数组中的重复数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 1.暴力解法
 * 2.交换（修改数组）
 */

public class Solution3 {
    /**
     * # 暴力解法
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate(int numbers[],int length,int [] duplication){
        for (int i = 0;i < length;i++){
            for (int j = i+1;j < length;j++){
                if (numbers[i] == numbers[j]){
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * # 交换--修改数组
     * 1.首先比较当前位置的数值(m)是否等于当前位置的下标(i)。
     * 2.如果条件1判断为false，继续判断m是否等于i
     * 3.如果条件2判断为true，则找到一个重复的数字，return true
     * 4.如果条件2判断为false，则交换numbers[numbers[i]]和numbers[i]的值。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate2(int numbers[],int length,int [] duplication){
        int tmp;
        for (int i = 0;i < length;i++){
            if(numbers[i] == i){
                continue;
            }else {
                if (numbers[numbers[i]] == numbers[i]){
                    duplication[0] = numbers[i];
                    return true;
                }else {
                    tmp = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = tmp;
                }
            }
        }
        return false;
    }
}
