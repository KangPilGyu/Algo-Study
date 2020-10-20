package week6;

class Node {
	int data;
	Node next = null;
	
	Node(int d) {
		this.data = d;
	}
	
	void append(int d) {  // 데이터 추가.
		Node end = new Node(d);  // 제일 끝에 추가할 노드 객체 생성.
		Node n = this;  // 노드에 현재 노드 정보 대입.
		while(n.next != null) {  // 다음이 null이 아닌 경우 계속 돌아. -> 끝까지 돌게 됨.
			n = n.next;
		}
		n.next = end;  // 마지막 노드의 next에 현재 노드 정보 넣어줌.
	}
	
	void delete(int d) {
		Node n = this;
		while(n.next != null) {
			if(n.next.data == d) {  // 현재 노드의 다음 노드가 지우려는 데이터를 가진 노드이면, 삭제하고 다음 노드 정보를 다음다음 노드 정보로 바꿈.
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}
	
	void retrieve() {
		Node n = this;
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);  // 마지막 데이터는 출력 못하고 while문 빠져나왔으므로 출력해줌.
	}
}

public class SinglyLinkedList {	
	public static void main(String[] args) {
		Node head = new Node(0);
		head.append(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.append(5);
		head.retrieve();
		head.delete(3);
		head.retrieve();
	}
}
