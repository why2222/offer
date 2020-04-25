public class Solution54 {

    private TreeNode res;
    private int count = 1;

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        inOrder(pRoot, k);
        return res;
    }

    private void inOrder(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return;
        }
        inOrder(pRoot.left, k);
        if (count == k) {
            res = pRoot;
            count++;
        } else {
            count++;
        }
        inOrder(pRoot.right, k);
    }

}
