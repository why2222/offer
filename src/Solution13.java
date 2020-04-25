public class Solution13 {
    public static int movingCount(int threshold, int rows, int cols) {
        int count = 0;
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            visited[i] = false;
        }
        count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    public static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    /**
     * 用来判断机器人能否进入坐标为(row,col)的方格。
     *
     * @param threshold:k
     * @param rows
     * @param cols
     * @param row：横坐标
     * @param col：纵坐标
     * @param visited：已经被访问,是一个数组，false表示没有被访问过，true表示已经被访问过
     * @return
     */
    public static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && col >= 0 && row < rows && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold
                && !visited[row * cols + col]) {
            return true;
        }
        return false;
    }

    public static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
