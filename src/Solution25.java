public class Solution25 {
    /**
     * 使用递归非常好用，从最后一个一次向前
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode MergeHead = null;
        if (list1.val <= list2.val) {
            MergeHead = list1;
            MergeHead.next = Merge(list1.next, list2);
        } else {
            MergeHead = list2;
            MergeHead.next = Merge(list1, list2.next);
        }
        return MergeHead;
    }
}
