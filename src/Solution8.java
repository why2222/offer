
public class Solution8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        TreeLinkNode pNext = null;
        if (pNode == null){
            return pNext;
        }
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            pNext = pRight;
        } else if (pNode.next != null) {
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pParent = pNode.next;
            while (pParent != null && pCurrent == pParent.right) {
                pCurrent = pParent;
                pParent = pParent.next;
            }
            pNext = pParent;
        }
        return pNext;
    }
}
