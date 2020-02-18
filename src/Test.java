import java.util.ArrayList;

/**
 * @auther why
 * @date 2019-11-18 - 17:13
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] m2 = {{1,2},{3,4},{5,6},{7,8},{9,10}};
        result = Solution29.printMatrix(m2);
        for (int i : result) {
            System.out.println("ArrayList:" + i);
        }
    }
}
