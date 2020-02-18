public class Solution27 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            return;
        }
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }
}
