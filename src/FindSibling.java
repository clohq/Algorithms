/*

1. Given an incomplete binary tree with parent pointer in each node and another input node N, find the sibling to the right of the node N. Write code for this .

*/

public class FindSibling {
	public static void main(String[] args) {
		TreeNode3 head = new TreeNode3(10, null);
		head.left = new TreeNode3(20, head);
		head.right = new TreeNode3(30, head);

		head.left.left = new TreeNode3(40, head.left);
		head.right.left = new TreeNode3(45, head.right);
		head.right.right = new TreeNode3(50, head.right);

		head.left.left.right = new TreeNode3(31, head.left.left);
		head.right.right.left = new TreeNode3(32, head.left.left);
		head.right.right.right = new TreeNode3(33, head.left.left);

		TreeNode3 input = head.left.left.right;

		TreeNode3 output = findSibling(input);

		if(output == null) {
			System.out.println("No sibling found");
		} else {
			System.out.println(output.value);
		}
	}

	public static TreeNode3 findSibling(TreeNode3 input) {

		TreeNode3 temp = input;

		TreeNode3 result = null;

		int level = 0;

		while(temp.parent != null) {

			TreeNode3 parent = temp.parent;
			level ++;
				
			if(parent.right != null && parent.right != temp) {

				int tempLevel = level - 1;

				TreeNode3 temp1 = parent.right;

				TreeNode3 current = temp1;
				TreeNode3 previous = temp1;

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

class TreeNode3 {
	int value;
	TreeNode3 left, right, parent;

	public TreeNode3(int value, TreeNode3 parent) { 
		this.value = value;
		this.parent = parent;
	}
}