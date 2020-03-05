import java.util.*;
import java.io.*;
public class Main{
	static int INF = 1 << 30;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int v = Integer.parseInt(input[0]) + 1, e = Integer.parseInt(input[1]), k = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<int[]>> list = new ArrayList<ArrayList<int[]>>();
		for(int i = 0; i < v; i++) list.add(new ArrayList<int[]>());
		int[] rst = new int[v], vst = new int[v];
		for(int i = 1; i < v; i++){
			if(i == k) continue;
			rst[i] = INF;
		}
		vst[k] = 1;
		
		for(int i = 0; i < e; i++){
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]), c = Integer.parseInt(input[2]);
			list.get(a).add(new int[] {b, c});
		}
		
		for(int i = 0; i < v; i++) list.get(i).sort((a, b) -> {return a[1] - b[1];});
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {return a[1] - b[1];});
		ArrayList<int[]> tmpList = list.get(k);
		int cnt = 1, size = tmpList.size();
		
		for(int i = 0; i < size; i++){
			// 시작지점과 연결된 경로를 우선순위 큐에 넣어준다.
			pq.add(tmpList.get(i));
		}
		while(cnt < v - 1 && !pq.isEmpty()){
			// 현재 우선순위 큐에 있는 가장 맨 앞의 원소를 꺼낸다.
			int[] poll = pq.poll();
			int a = poll[0], b = poll[1];
			// 해당 경로의 도착지점이 방문하지 않았던 곳이라면 결과값을 저장한다.
			if(vst[a] == 0) {
				vst[a] = 1;
				rst[a] = b;
				// 방문하지 않았던 곳이라면 그 점과 연결된 방문하지 않은 곳으로 향하는 경로를 우선순위 큐에 넣어준다.
				tmpList = list.get(a);
				size = tmpList.size();
				for(int i = 0; i < size; i++) {
					int[] tmpArr = tmpList.get(i);
					if(vst[tmpArr[0]] == 0) {
						tmpArr[1] += b;
						pq.add(tmpArr);
					}
				}
			}
		}
		for(int i = 1; i < v; i++){
			bw.write(rst[i] == INF ? "INF" : (rst[i] + ""));
			bw.write("\n");
		}
		bw.flush();
	}
}
