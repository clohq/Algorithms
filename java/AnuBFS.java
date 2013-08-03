
import java.util.ArrayList;
import java.lang.*;


class AnuBFS{

public static void main(String args[])	
{
	Node N1 = new Node() ;
	N1.val=1;
	Node N2 = new Node() ;
	N2.val=2;
	Node N3 = new Node() ;
	N3.val=3;
	Node N4 = new Node() ;
	N4.val=4;
	Node N5 = new Node() ;
	N5.val=5;
	Node N6 = new Node() ;
	N6.val=6;
	Node N7 = new Node() ;
	N7.val=7;
	Node N8 = new Node() ;
	N8.val=8;

	N1.childlist=new ArrayList();
	N1.childlist.add(N2);
	N1.childlist.add(N3);
	N1.childlist.add(N8);
	N2.childlist=new ArrayList();
	N2.childlist.add(N5);
	N2.childlist.add(N6);
	
	N3.childlist=new ArrayList();
	N3.childlist.add(N7);
	 doBFS(N1);
	
}
public static void doBFS(Node current){
	System.out.println(current.val);
    ArrayList<Node> temp = new ArrayList<Node>();
	while(current!=null){
		if(current.childlist!=null){
			for(Node child:current.childlist){
				System.out.println(child.val);
				temp.add(child);
			}
		}
		if(!temp.isEmpty()){
			current=temp.remove(0);
		
		}

	}
}




}  class Node{
	public int val;
	public ArrayList<Node> childlist;


}