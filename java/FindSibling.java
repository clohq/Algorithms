/*

1. Given an incomplete binary tree with parent pointer in each node and another input node N, find the sibling to the right of the node N. Write code for this .

*/

public class FindSibling {
	public static void main(String[] args) {
		TreeNode head = new TreeNode(10, null);
		head.left = new TreeNode(20, head);
		head.right = new TreeNode(30, head);

		head.left.left = new TreeNode(40, head.left);
		head.right.left = new TreeNode(45, head.right);
		head.right.right = new TreeNode(50, head.right);

		head.left.left.right = new TreeNode(31, head.left.left);
		head.right.right.left = new TreeNode(32, head.left.left);
		head.right.right.right = new TreeNode(33, head.left.left);

		TreeNode input = head.left.left.right;

		TreeNode output = findSibling(input);

		if(output == null) {
			System.out.println("No sibling found");
		} else {
			System.out.println(output.value);
		}
	}

	public static TreeNode findSibling(TreeNode input) {

		TreeNode temp = input;

		TreeNode result = null;

		int level = 0;

		while(temp.parent != null) {

			TreeNode parent = temp.parent;
			level ++;
				
			if(parent.right != null && parent.right != temp) {

				int tempLevel = level - 1;

				TreeNode temp1 = parent.right;

				TreeNode current = temp1;
				TreeNode previous = temp1;

				while(current != null && tempLevel != 0 && tempLevel < level) {

					if(current.left!= null && current.left!=previous) {
						previous = current;
						current = current.left;
						tempLevel--;
					} else if (current.right!= null && current.right!=previous) {
						previous = current;
						current = current.right;
						tempLevel--;					
					} else {
						previous = current;
						current = current.parent;
						tempLevel ++;
					}
				}

				if(tempLevel == 0) {
					result = current;
				}
			}

			temp = parent;
		}

		return result;
	}
}

class TreeNode {
	int value;
	TreeNode left, right, parent;

	public TreeNode(int value, TreeNode parent) { 
		this.value = value;
		this.parent = parent;
	}
}