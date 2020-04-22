import java.util.ArrayList;

public class Solution57 {

    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int head = 0;
        int tail = array.length - 1;
        while (head < tail) {
            if (array[head] + array[tail] > sum) {
                tail--;
            } else if (array[head] + array[tail] < sum) {
                head++;
            } else {
                res.add(array[head]);
                res.add(array[tail]);
                break;
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int head = 1;
        int tail = 2;
        while (tail <= (sum / 2) + 1) {
            int temp = (head + tail) * (tail - head + 1) / 2;
            if (temp < sum) {
                tail++;
                temp++;
            } else if (temp > sum) {
                head++;
                temp--;
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                for (int i = head; i <= tail; i++) {
                    arr.add(i);
                }
                res.add(arr);
                head++;
                temp--;
            }
        }
        return res;
    }
}
