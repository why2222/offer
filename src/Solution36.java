public class Solution36 {
    private static TreeNode pPre = null;
    private static TreeNode pHead = null;
    public static TreeNode Convert(TreeNode pRootOfTree) {
        ConvertNode(pRootOfTree);
        return pHead;
    }

    public static void ConvertNode(TreeNode pNode) {
        if (pNode == null) {
            return;
        }
        ConvertNode(pNode.left);
        pNode.left = pPre;
        if (pPre != null) {
            pPre.right = pNode;
        }
        pPre = pNode;
        if (pHead == null) {
            pHead = pNode;
        }
        ConvertNode(pNode.right);
    }
}
