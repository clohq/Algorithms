/*

Print the view of tree from either left side of right side

*/

import java.util.LinkedList;
import java.util.Queue;

public class TreeSide {
	public static void main(String[] args) {
		TreeNode6 head = getTree();

		printLeftSide(head);		
	}

	public static void printLeftSide(TreeNode6 head) {

		Queue<TreeNode6> temp = new LinkedList<>();

		TreeNode6 edge = new TreeNode6(-1);
		edge.edge = true;

		temp.offer(head);
		temp.offer(edge);

		System.out.println(head.getValue());

		while(!temp.isEmpty()) {
			TreeNode6 node = temp.poll();			
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

	public static TreeNode6 getTree() {
		
		//
		TreeNode6 head = new TreeNode6(10);

		///
		head.left = new TreeNode6(20);
		head.right = new TreeNode6(30);

		////

		head.left.left = new TreeNode6(40);
		head.left.right = new TreeNode6(50);

		head.right.left = new TreeNode6(60);
		head.right.right = new TreeNode6(70);

		/////

		head.left.left.left = new TreeNode6(80);
		head.left.left.right = new TreeNode6(90);

		head.left.right.left = new TreeNode6(100);
		head.left.right.right = new TreeNode6(110);

		head.right.left.left = new TreeNode6(120);
		head.right.left.right = new TreeNode6(130);

		head.right.right.left = new TreeNode6(140);
		head.right.right.right = new TreeNode6(150);

		return head;
	}
}

class TreeNode6 {
	public TreeNode6 left = null;
	public TreeNode6 right = null;
	public boolean edge = false;
	private int value;

	public TreeNode6(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}