import java.util.*;

public class testLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		printAll(list);

		list.remove();
		printAll(list);

		list.remove();
		list.remove();
		list.remove();
		printAll(list);

		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		printAll(list);
	}

	private static void printAll(LinkedList<Integer> list) {
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println("");
	}
}

class LinkedList<T> implements Iterable<T>{
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public void addFirst(T t) {
		if (this.head == null) {
			Node<T> newNode = new Node<T>(null, t, null);
			this.head = newNode;
			this.tail = newNode;
		} else {
			Node<T> newNode = new Node<T>(null, t, this.head);
			this.head.setPrev(newNode);
			this.head = newNode;
		}
		this.size++;
	}

	public T get(int index) {
		int i = 0;
		Node<T> node = this.head;

		while(i != index) {
			node = node.getNext();
			i ++;
			if (i > this.size) {
				throw new IndexOutOfBoundsException();
			}
		}
		return node.getContent();
	}

	public void remove() {
		Node<T> head = this.head;

		if (head != null && head.getNext() != null) {
			this.head = head.getNext();
		} else {
			this.head = null;
			this.tail = null;
		}
		this.size--;
	}

	public int indexOf(Object obj) {
		int i = 0;
		Node<T> node = this.head;

		while (!obj.equals(node.getContent())) {
			node = node.getNext();
			i ++;
			if (i > this.size) {
				return -1;
			}
		}
		return i;
	}

	public void push(T t) {
		if (this.tail == null) {
			Node<T> newNode = new Node<T>(null, t, null);
			this.head = newNode;
			this.tail = newNode;
		} else {
			Node<T> newNode = new Node<T>(this.tail, t, null);
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
		this.size++;
	}

	public int size() {
		return this.size;
	}

	@Override
	public Iterator<T> iterator() {
		return new nodeIterator<T>(this.head);
	}

	class nodeIterator<T> implements Iterator<T> {
		private Node<T> iter;

		public nodeIterator(Node<T> node) {
			Node<T> mockingNode = new Node<T>(null, null, node);
			this.iter = mockingNode;
		}

		@Override
		public boolean hasNext() {
			return (this.iter != null) && this.iter.getNext() != null;
		}

		@Override
		public T next() {
			this.iter = iter.getNext();
			return iter.getContent();
		}

	}
}

class Node<T> {
    private Node<T> prev;
    private Node<T> next;
    private T content;


    public Node(Node<T> prev, T content, Node<T> next) {
    	this.prev = prev;
    	this.content = content;
    	this.next = next;
	}

	public Node<T> getPrev() {
        return prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getContent() {
        return content;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
