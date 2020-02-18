public class Solution18 {
    public static void deleteNode(ListNode header, ListNode target) {
        if (header == null || target == null) {
            return;
        }
        // 要删除的节点不是尾节点
        if (target.next != null) {
            ListNode pNext = target.next;
            target.val = pNext.val;
            target.next = pNext.next;
        } else if (header == target) {
            target = null;
        } else {
            ListNode pNode = header;
            while (pNode.next != target) {
                pNode = pNode.next;
            }
            pNode.next = null;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pPreNode = null;
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            boolean needDelete = false;
            if (pNext != null && pNext.val == pNode.val) {
                needDelete = true;
            }
            if (!needDelete) {
                pPreNode = pNode;
                pNode = pNode.next;
            } else {
                int val = pNode.val;
                ListNode pToBeDel = pNode;
                while (pToBeDel != null && pToBeDel.val == val) {
                    pNext = pToBeDel.next;
                    pToBeDel = pNext;
                }
                if (pPreNode == null) {
                    pHead = pNext;
                } else {
                    pPreNode.next = pNext;
                }
                pNode = pNext;
            }
        }
        return pHead;
    }
}
