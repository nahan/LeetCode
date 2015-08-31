import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 
 * Notes:
 * You must use only standard operations of a queue -- which means 
 * only push to back, peek/pop from front, size, and is empty operations are valid.
 * 
 * Depending on your language, queue may not be supported natively. 
 * You may simulate a queue by using a list or deque (double-ended queue), 
 * as long as you use only standard operations of a queue.
 * 
 * You may assume that all operations are valid 
 * (for example, no pop or top operations will be called on an empty stack).
 * @author Han
 *
 */
class MyStack {
	public Queue<Integer> input = null;
	public Queue<Integer> output = null;
	
	public MyStack() {
		this.input = new PriorityQueue<Integer>();
		this.output = new PriorityQueue<Integer>();
	}
    // Push element x onto stack.
    public void push(int x) {
        this.input.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (this.input.size() > 1) {
        	this.output.add(this.input.poll());
        }
        this.input.poll();
        while (this.output.isEmpty() == false) {
        	this.input.add(this.output.poll());
        }
    }

    // Get the top element.
    public int top() {
    	while (this.input.size() > 1) {
        	this.output.add(this.input.poll());
        }
        int top = this.input.poll();
        this.output.add(top);
        while (this.output.isEmpty() == false) {
        	this.input.add(this.output.poll());
        }
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return this.input.isEmpty() && this.output.isEmpty();
    }
}
public class Solution {
	public static void main(String[] args) {
		MyStack st = new MyStack();
		st.push(1);
		st.push(2);
		System.out.println(st.top());
		st.pop();
		st.pop();
		System.out.println(st.empty());
		System.out.println(st.input.isEmpty());
		System.out.println(st.output.isEmpty());
	}
}
