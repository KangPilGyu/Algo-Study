import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 1000000001;
		int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[] rst = new int[n];
		for(int i = 0; i < n; i++) {
			rst[i] = max;
			Arrays.fill(arr[i], max);
		}
		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = Math.min(arr[a][b], c);
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken()) - 1, e = Integer.parseInt(st.nextToken()) - 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>() ;
		pq.add(s);
		arr[s][s] = 0;
		rst[s] = 0;
		while(!pq.isEmpty()) {
			int a = pq.poll();
			for(int i = 0; i < n; i++) {
				if(rst[i] > arr[a][i] + rst[a]) {
					rst[i] = arr[a][i] + rst[a];
					pq.add(i);
				}
			}
		}
		System.out.println(rst[e]);
	}
}
