package workspace;
import java.util.*;
class Main {
	public static void main(String[] a){
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(),K=sc.nextInt();
		Queue<Integer> que = new LinkedList<>();
		for(int i=1; i<N+1; i++)que.add(i);
		System.out.print("<");
		while(!que.isEmpty()) {
			for(int i=0; i<K; i++) {
				if(i==K-1)System.out.print(que.poll());
				else {
					que.add(que.poll());
				}
			}
			if(que.isEmpty())System.out.print(">");
			else System.out.print(", ");
		}
	}
}
