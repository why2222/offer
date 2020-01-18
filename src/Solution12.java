import java.util.jar.JarEntry;

public class Solution12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int flag[] = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (check(matrix, rows, cols, i, j, str, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i > rows || j < 0 || j > cols || matrix[index] != str[k] || flag[index] == 1) {
            return false;
        }
        if (k == str.length - 1) {
            return false;
        }
        flag[index] = 1;
        if (check(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || check(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || check(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || check(matrix, rows, cols, i, j - 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = 0;
        return false;
    }
}
