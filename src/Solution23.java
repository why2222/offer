public class Solution23 {
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (MeetingNode(pHead) == null) {
            return null;
        }
        ListNode mNode = MeetingNode(pHead);
        int count = NumOfLoop(mNode);
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        for (int i = 0; i < count; i++) {
            p1 = p1.next;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    /**
     * 用于查看链表中是否包含环
     * @param pHead
     * @return
     */
    public static ListNode MeetingNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pSlow = pHead.next;
        if (pSlow == null) {
            return null;
        }
        ListNode pFast = pSlow.next;
        while (pFast != null && pSlow != null) {
            if (pSlow == pFast) {
                return pFast;
            }
            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null) {
                pFast = pFast.next;
            }
        }
        return null;
    }

    public static int NumOfLoop(ListNode mNode) {
        int count = 1;
        ListNode nNode = mNode.next;
        while (nNode != mNode) {
            count++;
            nNode = nNode.next;
        }
        return count;
    }
}
