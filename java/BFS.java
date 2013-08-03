/*
	BFS
*/

import java.util.*;
import java.util.concurrent.*;

class TreeNode {
	int value;
	TreeNode left, right;

	public TreeNode(int value) {
		this.value = value;
	}
}

public class BFS {
	public static void main(String args[]) {
		TreeNode head = new TreeNode(10);

		head.left = new TreeNode(20);
		head.right = new TreeNode(30);
		

		head.left.left = new TreeNode(40);
		head.left.right = new TreeNode(50);
		head.right.left = new TreeNode(60);
		head.right.right = new TreeNode(70);

		printBFS(head);
	}

	public static void printBFS(TreeNode head) {
		Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();

		queue.offer(head);

		while(queue.size() > 0) {
			TreeNode node = queue.poll();
			System.out.println(node.value);
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
		}
	}
}