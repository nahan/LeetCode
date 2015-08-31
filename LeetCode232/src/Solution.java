import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue. 
 * pop() -- Removes the element from in front of queue. 
 * peek() -- Get the front element. 
 * empty() -- Return whether the queue is empty. 
 * 
 * Notes: 
 * You must use only standard operations of a stack -- which means 
 * only push to top, peek/pop from top, size, and is empty operations are valid. 
 * 
 * Depending on your language, stack may not be supported natively. 
 * You may simulate a stack by using a list or deque (double-ended queue), 
 * as long as you use only standard operations of a stack. 
 * 
 * You may assume that all operations are valid 
 * (for example, no pop or peek operations will be called on an empty queue).
 * 
 * @author Han
 *
 */

class MyQueue {
	
	private Stack<Integer> input = null;
	private Stack<Integer> output = null;
	
	public MyQueue() {
		this.input = new Stack<Integer>();
		this.output = new Stack<Integer>();
	}
	
    // Push element x to the back of queue.
    public void push(int x) {
        this.input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (this.input.isEmpty() == false) {
        	this.output.push(this.input.pop());
        }
        this.output.remove(this.output.size() - 1);
        while (this.output.isEmpty() == false) {
        	this.input.push(this.output.pop());
        }
    }

    // Get the front element.
    public int peek() {
    	while (this.input.isEmpty() == false) {
        	this.output.push(this.input.pop());
        }
    	int peek = this.output.peek();
    	while (this.output.isEmpty() == false) {
        	this.input.push(this.output.pop());
        }
        return peek;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return this.output.isEmpty() && this.input.isEmpty();
    }
}
public class Solution {
	public static void main(String[] args) {
		MyQueue my = new MyQueue();
		System.out.println(my.empty());
		for (int i = 0; i < 5; i ++) {
			my.push(i);
		}
		System.out.println(my.empty());
		
		while (my.empty() == false) {
			System.out.println(my.peek());
			my.pop();
			System.out.println(my.empty());
		}
		System.out.println(my.empty());
	}
}
