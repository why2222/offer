import java.util.Stack;

public class Solution31 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        if (pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> s = new Stack<>();
        for (int indexPush = 0, indexPop = 0; indexPush < pushA.length; indexPush++) {
            s.push(pushA[indexPush]);
            while (indexPop < popA.length && popA[indexPop] == s.peek()) {
                s.pop();
                indexPop++;
            }
        }
        return s.isEmpty();
    }
}
