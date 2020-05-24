
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Solution6 {
    // 栈的思想
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null)
            return list;
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (!stack.empty()){
            list.add(stack.pop().val);
        }
        return list;
    }

    // 递归
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null){
            return list;
        }
        if (listNode.next != null){
            // 注意：这里不要忘了用接收返回值！！！
            // 如果这里不接收返回值的话，则无法得到次级函数的结果，最后return的只是第一层函数的结果。
            list = printListFromTailToHead2(listNode.next);
        }
        list.add(listNode.val);

        return list;
    }

    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if(listNode == null){
            return null;
        }
        Stack<Integer> temp = new Stack<>();
        while(listNode != null){
            temp.push(listNode.val);
            listNode = listNode.next;
        }
        while (!temp.empty()) {
            res.add(temp.pop());
        }
        return res;
    }
}
