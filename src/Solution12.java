public class Solution12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // visited[] 记录该位置是否被访问过;true:已经被访问过；false：没有被访问过
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (check(matrix, rows, cols, i, j, str, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯，递推
     * @param matrix
     * @param rows
     * @param cols
     * @param x
     * @param y
     * @param str
     * @param k：字符串str当前的索引
     * @param visited
     * @return
     */
    public boolean check(char[] matrix, int rows, int cols, int x, int y, char[] str, int k, boolean[] visited) {

        // 根据x,y确定k:第一个元素在一维数组(matrix)的位置
        int index = x * cols + y;
        // 递归终止条件
        if (x < 0 || y < 0 || x >= rows || y >= cols ||
                visited[index] || matrix[index] != str[k]) {
            return false;
        }
        // 若k已经到达str末尾了，说明已经匹配成功
        if (k == str.length - 1) {
            return true;
        }
        visited[index] = true;
        if (check(matrix, rows, cols, x + 1, y, str, k + 1, visited) ||
                check(matrix, rows, cols, x - 1, y, str, k + 1, visited) ||
                check(matrix, rows, cols, x, y + 1, str, k + 1, visited) ||
                check(matrix, rows, cols, x, y - 1, str, k + 1, visited)) {
            return true;
        }
        visited[index] = false;
        return false;
    }
}
