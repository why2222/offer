import java.util.Stack;

public class Solution52 {
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (pHead1 != null) {
            s1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            s2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode res = null;
        while (s1.size() > 0 && s2.size() > 0) {
            if (s1.peek() == s2.peek()) {
                s1.pop();
                res = s2.pop();
            } else {
                return res;
            }
        }
        return res;
    }
}
