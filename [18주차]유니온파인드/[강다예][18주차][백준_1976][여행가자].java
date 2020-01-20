import java.util.Scanner;

public class Main {
	static int n,m;
	static int [] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); //도시 수
		m= sc.nextInt(); // 여행 계획에 속한 도시의 수
	
		parent = new int[n+1]; //부모
		
		for (int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		//연결되어 있다면 부모노드 merge
		
		for (int i = 1; i <=n; i++) {
			int connect;
			for (int j = 1; j <=n; j++) {
				if ( (connect=sc.nextInt()) == 1 && i<j) union(i,j);				
			}
		}//for
		
		
		 //여행계획
		boolean check = true;
		int first = sc.nextInt();
		for (int i = 0; i < m-1; i++) {
			int second = sc.nextInt();
			if (find(first) != find(second)) {
				check = false;
				break;
			}else {
				first = second;
			}
		}
		
		System.out.println(check == true? "YES" : "NO");
		
	        
		
	}
	 
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[b] =a;
				
	}
	 
	 static int find(int a) {
		if(a == parent[a])
		return a;
		else return parent[a] = find(parent[a]);
	}
}
