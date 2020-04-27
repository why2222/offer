/**
 * # 二维数组中查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 *
 * 1.暴力解法
 * 2.比较法
 */
public class Solution4 {
    /**
     * 暴力解法
     * 注意：if(array.length == 1)
     * @param target
     * @param array
     * @return
     */
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

    /**
     * 比较法
     * 1.选取矩阵右上角的元素作为查找起点，如果等于target，return true；
     * 2.如果元素大于target，根据矩阵排序规则可知，该元素是其所在列的最小元素，则可以排除当前列；
     * 3.如果元素小于target，根据矩阵排序规则可知，该元素是其所在行的最大元素，则可以排除当前行；
     * 4.重复2，3，缩小查找范围，直至找到target或搜索完真个二维数组。
     * @param target
     * @param array
     * @return
     */
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
