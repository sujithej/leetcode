import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        queue1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int temp;
        int size = queue1.size();
        for (int i = 0; i < size - 1; i++) {
            queue2.add(queue1.poll());
        }
        queue1 = queue2;
        queue2 = new LinkedList<>();

    }

    // Get the top element.
    public int top() {
        Integer temp = null;
        int size = queue1.size();
        for (int i = 0; i < size ; i++) {
            temp = queue1.poll();
            queue2.add(temp);
        }
        queue1 = queue2;
        queue2 = new LinkedList<>();
        return temp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return  queue1.isEmpty();

    }
}
