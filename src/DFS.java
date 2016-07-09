/*
	DFS
*/

class TreeNode2 {
	int value;
	TreeNode2 left, right;

	public TreeNode2(int value) {
		this.value = value;
	}
}

public class DFS {
	public static void main(String args[]) {
		TreeNode2 head = new TreeNode2(10);

		head.left = new TreeNode2(20);
		head.right = new TreeNode2(30);

		head.left.left = new TreeNode2(40);
		head.left.right = new TreeNode2(50);
		head.right.left = new TreeNode2(60);
		head.right.right = new TreeNode2(70);

		printDFS(head);
	}

	public static void printDFS(TreeNode2 head) {
		if(head != null) {
			System.out.println(head.value);
			printDFS(head.left);
			printDFS(head.right);
		}		
	}
}
