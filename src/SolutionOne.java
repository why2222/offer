/**
 * @auther why
 * @date 2019-11-18 - 16:35
 */
public class SolutionOne {
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
}
