import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class Solution29 {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix == null || rows <= 0 || cols <= 0) {
            return null;
        }
        int start = 0;
        while (cols > start * 2 && rows > start * 2) {
            printMatrixCircle(matrix, cols, rows, start, result);
            start++;
        }
        return result;
    }

    public static void printMatrixCircle(int[][] matrix, int cols, int rows, int start, ArrayList result) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        // 从左到右打印一行
        for (int i = start; i <= endX; i++) {
            result.add(matrix[start][i]);
            System.out.println(matrix[start][i]);
        }
        // 从上到下打印一列
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) {
                result.add(matrix[i][endX]);
                System.out.println(matrix[i][endX]);
            }
        }
        // 从右到左打印一行
        if (endX > start && endY > start ) {
            for (int i = endX - 1; i >= start; i--) {
                result.add(matrix[endY][i]);
                System.out.println(matrix[endY][i]);
            }
        }
        // 从下到上打印一列
        if (endX > start && endY > start + 1) {
            for (int i = endY - 1; i > start; i--) {
                result.add(matrix[i][start]);
                System.out.println(matrix[i][start]);
            }
        }
    }

}
