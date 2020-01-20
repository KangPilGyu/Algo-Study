import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static int F;
	static int [] parent,network;
	static HashMap<String , Integer> frd;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();				
				
		while (T-- >0) {			
			F= sc.nextInt();
			int idx =0;
			parent = new int[2*F];
			network = new int[2*F];
			
			frd = new HashMap<>();
			for (int i = 0; i <2*F; i++) {
				parent[i] = i;
				network[i] =1;
			} 
			
			for (int i = 0; i < F; i++) {
				String a = sc.next();
				String b = sc.next();
				
				if (!frd.containsKey(a)) {
					frd.put(a, idx++);
				}
				if (!frd.containsKey(b)) {
					frd.put(b, idx++);
				}
				union(frd.get(a),frd.get(b));				
			}//FOR
		}
				
	}

	 static void union(int p, int q) {
		 p = find(p);
		 q = find(q);		 
		 
		if(p!=q) {			 		
		parent[q] = p;
		network[p] += network[q];
		
		}
		System.out.println(network[p]);
		
		
		}

	 static int find(int a) {
		if (a== parent[a]) {
			return a;
		}else {
			return parent[a]  = find(parent[a]);
		}		
	}

	
}
