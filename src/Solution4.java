package src;

/**
 * @auther why
 * @date 2019-11-18 - 16:35
 */
public class Solution4 {
    // 暴力解法
    public static boolean Find(int target,int [][] array){
        if (array.length == 1)
            return false;
        for (int i = 0;i < array.length;i ++){
            for (int j = 0;j < array.length;j ++){
                if (array[i][j] == target){
                    return true;
                }else {
                    continue;
                }
            }
        }
        return false;
    }
    // 比较法
    public static boolean Find2(int target,int [][] array){
        boolean found = false;
        int rows,columns;
        rows = columns = array.length;
        if (array.length != 1){
            int row = 0;
            int column = columns - 1;
            while(row < array.length && column >= 0){
                if (array[row][column] == target){
                    found = true;
                    break;
                }else if (array[row][column] > target){
                    column -= 1;
                }else {
                    row += 1;
                }
            }
        }
        return found;
    }
}
