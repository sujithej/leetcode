import java.util.Stack;

public class StackQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Integer temp = null;
        if(stack2.empty()) {
            while(!stack1.empty()) {
                temp = stack1.pop();
                stack2.push(temp);
            }
        }
        stack2.pop();
    }

    // Get the front element.
    public int top() {
        Integer temp = null;
        if(stack2.empty()) {
            while(!stack1.empty()) {
                temp = stack1.pop();
                stack2.push(temp);
            }
        }
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
