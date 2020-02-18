public class Solution26 {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            return Tree1HasTree2(root1, root2)
                    || HasSubtree(root1.left, root2)
                    || HasSubtree(root1.right, root2);
        }
        return result;
    }

    public static boolean Tree1HasTree2(TreeNode tree1,TreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree1.val != tree2.val) {
            return false;
        }
        return Tree1HasTree2(tree1.left, tree2.left)
                && Tree1HasTree2(tree1.right, tree2.right);
    }
}
