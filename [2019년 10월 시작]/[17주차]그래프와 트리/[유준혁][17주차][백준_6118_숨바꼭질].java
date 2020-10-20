package baekjoon_tree;
import java.util.*;
public class baekjoon_6118 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dis = 0, cnt = 0, pos = 0, n = sc.nextInt(), m = sc.nextInt();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int[] vst = new int[n+1];
		for(int i = 0; i <= n; i++) list.add(new ArrayList<Integer>());
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1, 0}); vst[1] = 1;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if(dis < tmp[1]) {
				dis = tmp[1];
				cnt = 1;
				pos = tmp[0];
			}else {
				pos = Math.min(pos, tmp[0]);
				cnt++;
			}
			ArrayList<Integer> pollList = list.get(tmp[0]);
			int size = pollList.size();
			for(int i = 0; i < size; i++) {
				int x = pollList.get(i);
				if(vst[x] == 0) {
					vst[x] = 1;
					q.add(new int[] {x, tmp[1] + 1});
				}
			}
		}
		System.out.println(pos+" "+dis+" "+cnt);
	}
}
