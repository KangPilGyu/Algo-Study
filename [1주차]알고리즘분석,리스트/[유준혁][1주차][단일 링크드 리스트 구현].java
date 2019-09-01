package workspace;

/*
1. 단일 링크드 리스트(Single Linked List)
노드에 링크가 1개
단방향으로 진행

2. 이중(양방향) 링크드 리스트(Double Linked List)
노드에 링크가 2개
양방향으로 진행

3. 환형(원형) 링크드 리스트(Circular Linked List)
마지막 노드가 첫번째 노드를 가리킴
원형으로 진행 (회전)

[출처] 링크드 리스트(Linked List)|작성자 BlackP
 */
public class LinkedList{
	public static void main(String [] args) {
		SingleLinkedList<Integer> sl = new SingleLinkedList<>();
		sl.add(new Node<Integer>(1));
		System.out.println("sl.add(1) ->"+sl);
		sl.remove();
		System.out.println("sl.remove() ->"+sl);
		sl.add(new Node<Integer>(1));
		sl.add(new Node<Integer>(2));
		sl.add(new Node<Integer>(3));
		System.out.println(sl.get(2));
		System.out.println("head:"+sl.getHead()+", tail:"+sl.getTail());
		System.out.println(sl.size());
		System.out.println(sl);
		sl.remove();
		System.out.println("=============remove==============");
		System.out.println("head:"+sl.getHead()+", tail:"+sl.getTail());
		System.out.println(sl.size());
		System.out.println(sl);
		sl.add(new Node<Integer>(4));
		System.out.println("head:"+sl.getHead()+", tail:"+sl.getTail());
		System.out.println(sl.size());
		sl.remove(0);
		System.out.println("head:"+sl.getHead()+", tail:"+sl.getTail());
		System.out.println(sl.size());
		System.out.println(sl);
		System.out.println("=============setHead,setTail==============");
		sl.setHead(new Node<Integer>(1));
		System.out.println("setHead(1) ->"+sl);
		sl.setTail(new Node<Integer>(4));
		System.out.println("setTail(4) ->"+sl);
	}
}
class Node<T>{
	private Node<T> next;
	private T data;
	//constructor
	public Node(T t) {
		this.data=t;
	}
	//getter,setter,toString
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return data.toString();
	}
}
class SingleLinkedList<T>{
	private int size=0;
	private Node<T> head;
	private Node<T> tail;
	
	public SingleLinkedList(){}
	
	public void add(Node<T> node) {
		if(head==null) {
			head=node;
			tail=node;
		}else {
			this.tail.setNext(node);
			this.tail=node;
		}
		this.size++;
	}
	public void setHead(Node<T> node){
		node.setNext(this.head);
		this.head=node;
	}
	public void setTail(Node<T> node) {
		this.tail.setNext(node);
		this.tail=node;
	}
	public Node<T> getHead(){
		return this.head;
	}
	public Node<T> getTail(){
		return this.tail;
	}
	public Node<T> get(int index){
		if(index>=this.size || index<0) throw new IndexOutOfBoundsException(index);
		Node<T> node=this.head;
		for(int i=0; i<index; i++) node=node.getNext();
		return node;
	}
	public void remove() {
		if(this.size==1) {
			this.head=null;
			this.tail=null;
			this.size--;
			return;
		}
		Node<T> node = this.head;
		for(int i=0; i<size-2; i++)node=node.getNext();
		node.setNext(null);
		this.tail=node;
		this.size--;
	}
	public void remove(int index) {
		if(index>=this.size || index<0) throw new IndexOutOfBoundsException(index);
		if(index==0) {
			try{
				this.head=this.head.getNext();
				this.size--;
			}catch(IndexOutOfBoundsException e) {
				this.head=null;
				this.tail=null;
			}
		}else if(index==this.size-1) remove();
		else {
			get(index-1).setNext(get(index+1));
			this.size--;
		}
	}
	public int size() {
		return this.size;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<T> node = this.head;
		sb.append("[");
		while(node!=null) {
			sb.append(node.toString());
			node=node.getNext();
			if(node!=null)sb.append(", ");
		}
		sb.append("]");
		return new String(sb);
	}
}
