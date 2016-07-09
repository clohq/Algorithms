/*
	Tree Mirror
*/

class TreeNode4 {
	int value;
	TreeNode4 left, right;

	TreeNode4(int value) {
		this.value = value;
	}
}

public class TreeMirror {
	public static void main(String args[]) {
		TreeNode4 head1 = new TreeNode4(10);

		head1.left = new TreeNode4(20);
		head1.right = new TreeNode4(30);

		head1.left.left = new TreeNode4(40);
		head1.left.right = new TreeNode4(50);
		head1.right.left = new TreeNode4(60);
		head1.right.right = new TreeNode4(70);

		TreeNode4 head2 = new TreeNode4(10);

		head2.left = new TreeNode4(30);
		head2.right = new TreeNode4(20);

		head2.left.left = new TreeNode4(70);
		head2.left.right = new TreeNode4(60);
		head2.right.left = new TreeNode4(50);
		head2.right.right = new TreeNode4(40);

		System.out.println(compareTree(head1, head2));

	}

	public static boolean compareTree(TreeNode4 head1, TreeNode4 head2) {
		if(head1 != null && head2 != null) {
			if(head1.value != head2.value) 
				return false;
			else 
				return compareTree(head1.left, head2.right) && compareTree(head1.right, head2.left);
		} else {
			return head1 == head2;
		}
	}
}