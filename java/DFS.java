/*
	DFS
*/

class TreeNode {
	int value;
	TreeNode left, right;

	public TreeNode(int value) {
		this.value = value;
	}
}

public class DFS {
	public static void main(String args[]) {
		TreeNode head = new TreeNode(10);

		head.left = new TreeNode(20);
		head.right = new TreeNode(30);

		head.left.left = new TreeNode(40);
		head.left.right = new TreeNode(50);
		head.right.left = new TreeNode(60);
		head.right.right = new TreeNode(70);

		printDFS(head);
	}

	public static void printDFS(TreeNode head) {
		if(head != null) {
			System.out.println(head.value);
			printDFS(head.left);
			printDFS(head.right);
		}		
	}
}
