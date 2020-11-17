package dfs;

import java.io.*;
import java.util.*;

public class _2583 {
	static int n, m, sum;
	static int[][] arr;
	static boolean[][] vst;
	static int[][] wh = {{-1, 0, 1, 0}, {0, 1, 0, -1}};
	
	static void func(int x, int y){        
        // 4방향 확인
        for(int i = 0; i < 4; i++){
            int X = x + wh[0][i];
            int Y = y + wh[1][i];
            //범위 체크
            if(0 <= X && 0 <= Y && X < n && Y < m){
                //방문 체크 && 가능 여부 체크
                if(vst[X][Y] == false && arr[X][Y] == 0){
                    vst[X][Y] = true;
                    sum++;
                    func(X, Y);
                }
            }
        }
    }
	
	static int Int(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Int(st.nextToken());	// 세로
		n = Int(st.nextToken());	// 가로
		int k = Int(st.nextToken());	// 개수
		
		arr = new int[n][m];
		vst = new boolean[n][m];
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Int(st.nextToken());
			int b = Int(st.nextToken());
			int c = Int(st.nextToken());
			int d = Int(st.nextToken());
			
			for (int x = a; x < c; x++) {
				for (int y = b; y < d; y++)
					arr[x][y] = 1;
			}
		}
		
		ArrayList<Integer> al = new ArrayList<>();
		
		for (int i = 0; i < n; i++){
			for (int j = 0; j < m; j++) {
	            if (arr[i][j] == 0 && vst[i][j] == false) {
	                vst[i][j] = true;
	                sum = 1;
	                func(i, j);
	                al.add(sum);
	            }
			}
        }

		System.out.println(al.size());	
		
		Collections.sort(al);
		
		for (int a : al) 
			System.out.print(a + " ");
	}
}