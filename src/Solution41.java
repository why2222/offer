import java.util.PriorityQueue;
import java.util.Stack;

public class Solution41 {

    // 用最大堆、最小堆来实现
    Stack<Integer> min = new Stack<>();
    Stack<Integer> max = new Stack<>();
    int number = 0;

    public void Insert(Integer num) {
        number++;
        if (min.size() == 0 && (max.size() == 0 || num <= max.peek())) {
            min.push(num);
            return;
        }
        if (max.size() == 0 && (min.size() == 0 || num >= min.peek())) {
            max.push(num);
            return;
        }
        if (num > max.peek()) {
            while (max.size() != 0 && num > max.peek()) {
                min.push(max.pop());
            }
        }
        if (num < min.peek()) {
            while (min.size() != 0 && num < min.peek()) {
                max.push(min.pop());
            }
        }
        min.push(num);
    }

    public Double GetMedian() {
        while (min.size() < number / 2) {
            min.push(max.pop());
        }
        while (min.size() > number / 2) {
            max.push(min.pop());
        }
        if (number % 2 == 0) {
            return (max.peek() + min.peek()) / 2.0;
        }else {
            return min.size() > max.size() ? (double) min.peek() : (double) max.peek();
        }
    }

    private PriorityQueue<Integer> left = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    private int N = 0;

    public void Insert2(Integer num) {
        if (N % 2 == 0) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian2() {
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double) right.peek();
        }
    }
}
