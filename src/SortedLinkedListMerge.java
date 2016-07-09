/*

Given two sorted Linked Lists, write a code to merge them in place. Write test cases for the code.

*/

public class SortedLinkedListMerge {
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList(1);
		list1.next = new LinkedList(1);
		list1.next.next = new LinkedList(1);
		list1.next.next.next = new LinkedList(1);
		
		LinkedList list2 = new LinkedList(1);
		list2.next = new LinkedList(2);
		list2.next.next = new LinkedList(3);
		list2.next.next.next = new LinkedList(4);
		list2.next.next.next.next = new LinkedList(5);

		LinkedList result = merge(list2, list1);

		while(result != null) {
			System.out.println(result.value);
			result = result.next;
		}

	}

	public static LinkedList merge(LinkedList list1, LinkedList list2) {
		//Dummy node
		LinkedList temp = new LinkedList(-1);
		temp.next = list1;

		LinkedList head = temp;

		while(list1 != null) {

			if(list2 == null) {
				break;
			}

			if(list1.value < list2.value) {
				temp = list1;
				list1 = list1.next;
			} else {
				temp.next = list2;
				list2 = list2.next;
				temp = temp.next;
				temp.next = list1;
			}

		}

		while(list2 != null) {
			temp.next = list2;
			temp = list2;
			list2 = list2.next;
		}

		return head.next;
	}
}

class LinkedList {
	public int value = 0;
	public LinkedList next = null;

	LinkedList(int value) {
		this.value = value;
	}
}