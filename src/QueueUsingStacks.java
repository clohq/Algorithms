/*

Implement a Queue using Stacks

*/

import java.util.*;

public class QueueUsingStacks {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	}
}

class MyQueue {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void enqueue(int i) {
		stack1.push(i);
	}

	public int dequeue() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		return stack2.pop();
	}
}