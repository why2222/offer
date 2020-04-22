public class Solution35 {
    public RandomListNode Clone(RandomListNode pHead) {
        CloneNode(pHead);
        ConnectRandomNodes(pHead);
        return ReconnectNodes(pHead);
    }

    /**
     * 复制链表第一步：N-N'
     * @param pHead
     */
    public void CloneNode(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pClone = new RandomListNode();
            pClone.label = pNode.label;
            pClone.next = pNode.next;
            pNode.next = pClone;
            pNode = pClone.next;
        }
    }

    /**
     * 复制链表第二部：完成Random连接
     * @param pHead
     */
    public void ConnectRandomNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pClone = pNode.next;
            if (pNode.random != null) {
                pClone.random = pNode.random.next;
            }
            pNode = pClone.next;
        }
    }

    public RandomListNode ReconnectNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pCloneHead = null;
        RandomListNode pCloneNode = null;

        if (pNode != null) {
            pCloneHead = pCloneNode = pNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            pCloneNode.next = pNode.next;
            pCloneNode = pCloneNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        return pCloneHead;
    }

}
