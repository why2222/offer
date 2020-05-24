import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int one = 1;
        int two = 2;
        int res = 0;
        for (int i = 3; i <= target; i++) {
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        while (listNode != null) {
            s.push(listNode.val);
            listNode = listNode.next;
        }
        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;
    }

    public int minNumberInRotateArray(int [] array) {
        if (array == null) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return 0;
    }

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public int JumpFloor2(int target) {
        if (target <= 2) {
            return target;
        }
        int one = 1, two = 2;
        int res = 0;
        for (int i = 3; i <= target; i++) {
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }

    public int JumpFloorII(int target) {
        if (target <= 2) {
            return target;
        }
        int[] nums = new int[target + 1];
        int sum = 1;
        for (int i = 2; i <= target; i++) {
            nums[i] = sum + 1;
            sum += nums[i];
        }
        return nums[target];
    }
}
