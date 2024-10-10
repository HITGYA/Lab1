package queue;
import java.util.Iterator; 

import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;;
//  用于测试，修改了文件
//  B1修改文件
public class Queue<Item> implements Iterable <Item>{
	private class Node{
		Item item;
		Node next;
	}
	private int N=0;
	private Node first;
	private Node last;
	public Queue() {
		first=null;
		last=null;
		N=0;
	}
	public boolean isEmpty() {return N==0;}
	public int size() {return N;}
	private void enqueue(Item i) {
		Node oldlast=last;
		Node last=new Node();
		last.item=i;last.next=null;
		//先判断原先last有没有东西。
		if(isEmpty())first=last;
		else oldlast.next=last;
		N++;
	}
	public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item =first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }
	public Iterator<Item> iterator(){return new QueueIterator();}
	private class QueueIterator implements Iterator <Item>{
		private Node current=first;
		public boolean hasNext() {return current!=null;}
	    public Item next()  
	    {  if (!hasNext()) throw new NoSuchElementException();
           Item item=current.item;
           current=current.next;
           return item;}
	  public void main(String[] args) {
	        Queue<String> queue = new Queue<String>();
	        while (!StdIn.isEmpty()) {
	            String item = StdIn.readString();
	            if (!item.equals("-"))
	                queue.enqueue(item);
	            else if (!queue.isEmpty())
	                StdOut.print(queue.dequeue() + " ");
	        }
}
}//和现实队伍一样，从前端删除，后端加入。
}

