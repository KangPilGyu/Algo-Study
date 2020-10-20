import java.util.*;
class Main{
	static int INF = 987654321;
	public static void main(String[] ar){
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt() + 1, e = sc.nextInt(), k = sc.nextInt();
		int[][] route = new int[v][v];
		int[] rst = new int[v], vst = new int[v];
		for(int i = 1; i < v; i++){
			if(i == k) continue;
			rst[i] = INF;
		}
		vst[k] = 1;
		for(int i = 1; i < v; i++){
			for(int j = 1; j < v; j++){
				route[i][j] = INF;
			}
		}
		for(int i = 0; i < e; i++){
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
			route[a][b] = Math.min(route[a][b], c);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {return a[2] - b[2];});
		int cnt = 1;
		for(int i = 1; i < v; i++){
			if(route[k][i] != INF) {
				pq.add(new int[] {k, i, route[k][i]});
                vst[i] = 1;
			}
		}
		while(cnt < v - 1 && !pq.isEmpty()){
			int[] poll = pq.poll();
			int a = poll[0], b = poll[1], c = poll[2];
            cnt++;
            rst[b] = c;
            for(int i = 1 ; i < v; i++){
                int min = INF;
                if(vst[i] == 0 && route[b][i] < min) {
                    pq.add(new int[] {b, i, route[b][i] + c});
                    vst[i] = 1;
                    min = route[b][i];
                }
            }
		}
		for(int i = 1; i < v; i++){
			System.out.println(rst[i] == INF ? "INF" : rst[i]);
		}
	}
}