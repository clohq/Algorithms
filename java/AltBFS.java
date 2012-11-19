/*

Print Tree in a zigzag BFS style.

*/

import java.util.Stack;


public class AltBFS {
	public static void main(String[] args) {
		TreeNode head = getTree();

		Stack<TreeNode> leftStack = new Stack<TreeNode>();		
		Stack<TreeNode> rightStack = new Stack<TreeNode>();		
		
		rightStack.push(head);
		System.out.println(head.getValue());

		while(!rightStack.isEmpty() || !leftStack.isEmpty()) {

			while(!rightStack.isEmpty()) {
				TreeNode node = rightStack.pop();
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
				TreeNode node = leftStack.pop();
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

	public static TreeNode getTree() {
		
		//
		TreeNode head = new TreeNode(10);

		///
		head.left= new TreeNode(30);
		head.right= new TreeNode(20);

		////

		head.left.left= new TreeNode(40);
		head.left.right= new TreeNode(50);

		head.right.left= new TreeNode(60);
		head.right.right= new TreeNode(70);

		/////

		head.left.left.left= new TreeNode(150);
		head.left.left.right= new TreeNode(140);

		head.left.right.left= new TreeNode(130);
		head.left.right.right= new TreeNode(120);

		head.right.left.left= new TreeNode(110);
		head.right.left.right= new TreeNode(100);

		head.right.right.left= new TreeNode(90);
		head.right.right.right= new TreeNode(80);

		return head;
	}
}

class TreeNode {
	private int value;
	public TreeNode left = null;
	public TreeNode right = null;

	public TreeNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}