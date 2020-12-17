import java.util.*;
public class Main {
	static int n;
	static List<int[]>[] map;
	static int[] bfs(int i) {
		int[] vst = new int[n + 1];
		vst[i] = 1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, 0});
		int[] rst = {i, 0};
		while(!q.isEmpty()) {
			int[] p = q.poll();
			if(rst[1] < p[1]) rst = p;
			int a = p[0], d = p[1];
			for(int[] arr : map[a]) {
				if(vst[arr[0]] == 0) {
					vst[arr[0]] = 1;
					q.add(new int[] {arr[0], d + arr[1]});
				}
			}
		}
		return rst;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new List[n + 1];
		for(int i = 0; i < n + 1; i++) map[i] = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			while(true) {
				int b = sc.nextInt();
				if(b == -1) break;
				int c = sc.nextInt();
				map[a].add(new int[] {b, c});
				map[b].add(new int[] {a, c});
			}
		}
		int[] a = bfs(1);
		int[] b = bfs(a[0]);
		System.out.println(b[1]);
	}
}