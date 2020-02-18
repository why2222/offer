import java.util.Stack;

public class Solution30 {

    Stack<Integer> m_data = new Stack<>();
    Stack<Integer> m_min = new Stack<>();

    public void push(int node) {
        m_data.push(node);
        if (m_min.size() == 0 || node < m_min.peek()) {
            m_min.push(node);
        } else {
            m_min.push(m_min.peek());
        }
    }

    public void pop() {
        m_data.pop();
        m_min.pop();
    }

    public int top() {
        return m_data.peek();
    }

    public int min() {
        return m_min.peek();
    }
}
