import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


class TreeNode5 {
    int value;
    int sum;
    TreeNode5 left, right;

    public TreeNode5(int value) {
        this.value = value;
    }
}

public class TreeNodeDiffFinder {

    public static void findDiff(TreeNode5 head1, TreeNode5 head2) {
        if(head1 != null && head2 != null) {
            if(head1.value == head2.value) {
                if(head1.left != null && head2.left != null) {
                    if(head1.left.sum != head2.left.sum) {
                        findDiff(head1.left, head2.left);
                    } 
                } else if(head1.right != null && head2.right != null) {
                    if(head1.right.sum != head2.right.sum) {
                        findDiff(head1.right, head2.right);
                    }
                } else {
                    return;
                }
            } else {
                System.out.println("Found Mismatch");
                return;
            }
        } else {
            return;
        }
    }

    public static void insert(TreeNode5 head, int value) {
        if (value < head.value) {
            if(head.left == null) {
                TreeNode5 node = new TreeNode5(value);
                node.sum = 0;
                head.left = node;                
            } else {
                insert(head.left, value);
            }
        } else {
            if(head.right == null) {
                TreeNode5 node = new TreeNode5(value);
                node.sum = 0;
                head.right = node;
            } else {
                insert(head.right, value);
            }
        }

        head.sum = head.sum + value;
    }

    public static void main(String args[]) {
        TreeNode5 head = new TreeNode5(7);

        insert(head, 5);
        insert(head, 8);
        insert(head, 3);
        insert(head, 10);

        TreeNode5 head1 = new TreeNode5(7);

        insert(head1, 4);
        insert(head1, 8);
        insert(head1, 3);
        insert(head1, 10);

        findDiff(head, head1);

        printBFS(head);
        printBFS(head1);

    }

    public static void printBFS(TreeNode5 head) {
        Queue<TreeNode5> queue = new LinkedBlockingQueue<TreeNode5>();

        queue.offer(head);

        while(queue.size() > 0) {
            TreeNode5 node = queue.poll();
            System.out.println(node.value + " " + node.sum);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
    }
}