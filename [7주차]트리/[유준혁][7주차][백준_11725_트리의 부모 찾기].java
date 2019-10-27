package baekjoon_tree;
import java.util.*;
public class baekjoon_11725 {
	// 인접리스트는 이런식으로 구현해야한다고 한다.
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
	static boolean [] visit;
    static int [] parent;
    
    // bfs아니고 dfs여도 풀릴듯
    public static void bfs(int x){
    	Queue<Integer> q = new LinkedList<>();
    	q.add(x);
    	visit[x] = true;
    	
    	while(!q.isEmpty()) {
    		int i = q.poll();
    		for(int y : arr.get(i)) {
    			if (!visit[y]) {
    				visit[y] = true;
    				parent[y] = i;
    				q.add(y);
    			}
    		}
    	}
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        parent = new int [n+1];
        for(int i=0; i<n+1; i++) arr.add(new ArrayList<>());
        visit = new boolean [n+1];
        // 양방향 인접리스트이기 때문에 양쪽 다 넣어줌.
        for(int i=0; i<n-1; i++){
        	int x = sc.nextInt();
        	int y = sc.nextInt();
            arr.get(x).add(y);
            arr.get(y).add(x);
        }
        bfs(1);
        for(int i=2; i<n+1; i++) System.out.println(parent[i]);
    }
}
