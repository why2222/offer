public class Solution55 {
    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nLeft = TreeDepth(root.left);
        int nRight = TreeDepth(root.right);

        return nLeft > nRight ? nLeft + 1 : nRight + 1;
    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        boolean res = false;
        if (root == null) {
            return true;
        }
        int nLeft = TreeDepth(root.left);
        int nRight = TreeDepth(root.right);

        int diff = nLeft - nRight;
        if (diff == -1 || diff == 1 || diff == 0) {
            res = true;
        }

        return res;
    }
}
