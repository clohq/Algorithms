/*

Print the view of tree from either left side of right side

*/

import java.util.*;

public class TreeSide {
	public static void main(String[] args) {
		TreeNode head = getTree();

		printLeftSide(head);		
	}

	public static void printLeftSide(TreeNode head) {

		Queue<TreeNode> temp = new LinkedList<TreeNode>();

		TreeNode edge = new TreeNode(-1);
		edge.edge = true;

		temp.offer(head);
		temp.offer(edge);

		System.out.println(head.getValue());

		while(!temp.isEmpty()) {
			TreeNode node = temp.poll();			
			if(node.edge) {
				temp.offer(node);
				node = temp.poll();
				if(node.edge) break;
				else System.out.println(node.getValue());
			}
			
			//Swtich these to swtich sides
			if(node.right!= null)
				temp.offer(node.right);

			if(node.left!= null)
				temp.offer(node.left);				

		}

	}

	public static TreeNode getTree() {
		
		//
		TreeNode head = new TreeNode(10);

		///
		head.left= new TreeNode(20);
		head.right= new TreeNode(30);

		////

		head.left.left= new TreeNode(40);
		head.left.right= new TreeNode(50);

		head.right.left= new TreeNode(60);
		head.right.right= new TreeNode(70);

		/////

		head.left.left.left= new TreeNode(80);
		head.left.left.right= new TreeNode(90);

		head.left.right.left= new TreeNode(100);
		head.left.right.right= new TreeNode(110);

		head.right.left.left= new TreeNode(120);
		head.right.left.right= new TreeNode(130);

		head.right.right.left= new TreeNode(140);
		head.right.right.right= new TreeNode(150);

		return head;
	}
}

class TreeNode {
	private int value;
	public TreeNode left = null;
	public TreeNode right = null;
	public boolean edge = false;

	public TreeNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}