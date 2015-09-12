import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * @author Han
 *
 */
class MinStack {
    private int index = -1;
    private int maxInteger = (int) (Math.pow(2, 31) - 1);
    private int min = maxInteger;
    private ArrayList<Integer> array = new ArrayList<Integer>();
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    
    public void push(int x) {
        index++;
        this.array.add(x);
        this.queue.add(x);
        this.min = this.queue.peek();
    }

    public void pop() {
        if (index >= 0) {
            this.queue.remove(this.array.get(index));
            this.array.remove(index);
            if (this.queue.size() == 0) {
                this.min = this.maxInteger;
            } else {
                this.min = this.queue.peek();
            }
            index--;
        }
    }

    public int top() {
        return this.array.get(index);
    }

    public int getMin() {
        return this.min;
    }
}
public class Solution {
    public static void main(String[] args) {
        
        MinStack st1 = new MinStack();
        st1.push(2147483646);
        st1.push(2147483646);
        st1.push(2147483647);
        System.out.println(st1.top());
        st1.pop();
        System.out.println(st1.getMin());
        st1.pop();
        System.out.println(st1.getMin());
        st1.pop();
        st1.push(2147483647);
        System.out.println(st1.top());
        System.out.println(st1.getMin());
        st1.push(-2147483648);
        System.out.println(st1.top());
        System.out.println(st1.getMin());
        st1.pop();
        System.out.println(st1.getMin());
        
    }
}
