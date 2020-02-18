public class Solution22 {
    /**
     * 这种方法需要遍历列表两次
     * 第一次：得到链表的长度。
     * 第二次：找到第倒数第k个节点。
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0 ) {
            return null;
        }
        ListNode pNode = head;
        int listCount = 1;
        while (pNode.next != null) {
            pNode = pNode.next;
            listCount++;
        }
        // 注意不要遗漏这个边界条件：当k大于链表的长度。
        if (k > listCount) {
            return null;
        }
        ListNode kNode = head;
        for (int i = 1; i < listCount - k + 1; i++) {
            kNode = kNode.next;
        }
        return kNode;
    }

    public static ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode kNode = head;
        ListNode tNode = head;
        int count = 1;
        while (count < k) {
            tNode = tNode.next;
            if (tNode == null) {
                return null;
            }
            count++;
        }
        while (tNode.next != null) {
            kNode = kNode.next;
            tNode = tNode.next;
        }
        return kNode;
    }
}
