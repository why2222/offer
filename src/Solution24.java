public class Solution24 {
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pReverseHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) {
                pReverseHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }
}
