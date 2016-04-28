import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by sujith.j on 28/04/16.
 */
public class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> minHeap;
    HashMap<Integer,Integer> hashMapCount;

    public MinStack() {
        stack = new Stack<>();
        minHeap = new PriorityQueue<>();
        hashMapCount = new HashMap<>();
    }

    public void push(int x) {
        stack.push(x);
        minHeap.add(x);
    }

    public void pop() {
        int temp = stack.pop();
        if(hashMapCount.containsKey(temp)) {
            hashMapCount.put(temp,hashMapCount.get(temp)+1);
        } else {
            hashMapCount.put(temp,1);
        }
        int temp1 = temp;
        while(!minHeap.isEmpty() && minHeap.peek() == temp1 && hashMapCount.containsKey(temp1) && hashMapCount.get(temp1) > 0) {
            minHeap.poll();
            hashMapCount.put(temp1,hashMapCount.get(temp1) -1);
            if(!minHeap.isEmpty())
                temp1 = minHeap.peek();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minHeap.peek();
    }
}
