/*
	Tree Mirror
*/

class TreeNode {
	int value;
	TreeNode left, right;

	TreeNode(int value) {
		this.value = value;
	}
}

public class TreeMirror {
	public static void main(String args[]) {
		TreeNode head1 = new TreeNode(10);

		head1.left = new TreeNode(20);
		head1.right = new TreeNode(30);

		head1.left.left = new TreeNode(40);
		head1.left.right = new TreeNode(50);
		head1.right.left = new TreeNode(60);
		head1.right.right = new TreeNode(70);

		TreeNode head2 = new TreeNode(10);

		head2.left = new TreeNode(30);
		head2.right = new TreeNode(20);

		head2.left.left = new TreeNode(70);
		head2.left.right = new TreeNode(60);
		head2.right.left = new TreeNode(50);
		head2.right.right = new TreeNode(40);

		System.out.println(compareTree(head1, head2));

	}

	public static boolean compareTree(TreeNode head1, TreeNode head2) {
		if(head1 != null && head2 != null) {
			if(head1.value != head2.value) 
				return false;
			else 
				return compareTree(head1.left, head2.right) && compareTree(head1.right, head2.left);
		} else {
			if(head1 != head2) {
				return false;
			} else {
				return true;
			}
		}
	}
}