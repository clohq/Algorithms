/*

Print Tree in a zigzag BFS style.

*/

import java.util.Stack;


public class AltBFS {
	public static void main(String[] args) {
		TreeNode1 head = getTree();

		Stack<TreeNode1> leftStack = new Stack<TreeNode1>();
		Stack<TreeNode1> rightStack = new Stack<TreeNode1>();		
		
		rightStack.push(head);
		System.out.println(head.getValue());

		while(!rightStack.isEmpty() || !leftStack.isEmpty()) {

			while(!rightStack.isEmpty()) {
				TreeNode1 node = rightStack.pop();
				if(node.right!= null) {
					System.out.println(node.right.getValue());
					leftStack.push(node.right);
				}
				if(node.left!= null) {
					System.out.println(node.left.getValue());
					leftStack.push(node.left);
				}				
			}

			while(!leftStack.isEmpty()) {
				TreeNode1 node = leftStack.pop();
				if(node.left!= null) {
					System.out.println(node.left.getValue());
					rightStack.push(node.left);
				}
				if(node.right!= null) {
					System.out.println(node.right.getValue());
					rightStack.push(node.right);
				}
			}
		}
	}

	public static TreeNode1 getTree() {
		
		//
		TreeNode1 head = new TreeNode1(10);

		///
		head.left = new TreeNode1(30);
		head.right = new TreeNode1(20);

		////

		head.left.left = new TreeNode1(40);
		head.left.right = new TreeNode1(50);

		head.right.left = new TreeNode1(60);
		head.right.right = new TreeNode1(70);

		/////

		head.left.left.left = new TreeNode1(150);
		head.left.left.right = new TreeNode1(140);

		head.left.right.left = new TreeNode1(130);
		head.left.right.right = new TreeNode1(120);

		head.right.left.left = new TreeNode1(110);
		head.right.left.right = new TreeNode1(100);

		head.right.right.left = new TreeNode1(90);
		head.right.right.right = new TreeNode1(80);

		return head;
	}
}

class TreeNode1 {
	public TreeNode1 left = null;
	public TreeNode1 right = null;
	private int value;

	public TreeNode1(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}