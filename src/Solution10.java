public class Solution10 {
    // 使用递归，跳进陷阱，复杂度高
    public int Fibonacci(int n) {
        int result;
        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            result = Fibonacci(n - 1) + Fibonacci(n - 2);
        }
        return result;
    }

    public int Fibonacci2(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }
        int zero = 0;
        int one = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = zero + one;
            zero = one;
            one = res;
        }

        return res;
    }

    // 跳台阶(递归)
    public int JumpFloor(int target) {
        // 初始条件
        if (target <= 2) {
            return target;
        }

        return JumpFloor(target - 1) + JumpFloor(target - 2);

    }

    // 跳台阶 (Fibonacci)
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

    // 跳台阶 (变态)
    public int JumpFloorPro(int target) {
        if (target <= 2) {
            return target;
        }
        int nums[] = new int[target + 1];
        nums[0] = 1;
        nums[1] = 2;
        int sum = 1;
        for (int i = 2; i <= target; i++) {
            nums[i] = sum + 1;
            sum = sum + nums[i];
        }
        return nums[target];
    }

    // 覆盖矩形
    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int one = 1;
        int two = 2;
        int res = 1;
        for (int i = 3; i <= target; i++) {
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }
}
