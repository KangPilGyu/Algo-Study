package d0224_Simulation_1_3055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try {
			
			// 입력 및 필요한 변수 선언
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[R][C];
			
			boolean[][] visit = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					visit[i][j] = false;
				}
			}
			
			List<int[]> water = new ArrayList<int[]>();
			
			int[] now = new int[2];
			
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '*') {
						int[] arr = new int[2];
						arr[0] = i;
						arr[1] = j;
						water.add(arr);
					}else if(map[i][j] == 'S') {
						now[0] = i;
						now[1] = j;
						map[i][j] = '.';
						
						visit[i][j] = true;
					}
				}
			}
			
			Queue<int[]> coordinates = new LinkedList<int[]>();
			coordinates.add(now);
			
			int minTime = -1;
			
			
			
			////////////////////////////////////////////////////////////////////////////////////
						
			// 매 시간(1초)마다 시행한다.
			
			// 먼저 물을 퍼뜨리는 시행을 한 후,
			// 고슴도치가 이동할 수 있는 모든 경우의 수를 시행한다.
			
			// 고슴도치는 최대 지도 전체를 한 번씩 방문할 수 있는 시간만큼 움직이며 (R*C - 1번)
			// 고슴도치가 비버의 굴에 도착하면 즉시 종료한다(최소 시간이므로).
			
			// 중복을 없애기 위해 방문한 칸은 visit 처리함
			
			for (int time = 1; time < R*C; time++) {
				
				// 물 퍼지게 하기
				List<int[]> extendedWater = new ArrayList<int[]>(); 
				for (int[] w : water) {
					int i = w[0];
					int j = w[1];
					
					if(0 < i && map[i-1][j] == '.') {
						map[i-1][j] = '*';
						
						int[] arr = new int[2];
						arr[0] = i-1;
						arr[1] = j;
						
						extendedWater.add(arr);
					}
					
					if(i < R - 1 && map[i+1][j] == '.') {
						map[i+1][j] = '*';
						
						int[] arr = new int[2];
						arr[0] = i+1;
						arr[1] = j;
						
						extendedWater.add(arr);
					}
					
					if(0 < j && map[i][j-1] == '.') {
						map[i][j-1] = '*';
						
						int[] arr = new int[2];
						arr[0] = i;
						arr[1] = j-1;
						
						extendedWater.add(arr);
					}
					
					if(j < C - 1 && map[i][j+1] == '.') {
						map[i][j+1] = '*';
						
						int[] arr = new int[2];
						arr[0] = i;
						arr[1] = j+1;
						
						extendedWater.add(arr);
					}
				}
				water = extendedWater;
				
				// 현재 위치에 대해 모든 이동 가능한 경우의 수를 시행
				Queue<int[]> nextCoordinates = new LinkedList<int[]>();
				while(!coordinates.isEmpty()) {
					int i = coordinates.peek()[0];
					int j = coordinates.poll()[1];
					
					if( 0 < i && map[i-1][j] == 'D'
						||	i < R-1 && map[i+1][j] == 'D'
						||	0 < j && map[i][j-1] == 'D'
						||	j < C-1 && map[i][j+1] == 'D')	
					{
						minTime = time;
						break;
					}
					
					if(0 < i && map[i-1][j] == '.' && visit[i-1][j] == false) {
						int[] next = new int[2];
						next[0] = i-1;
						next[1] = j;
						
						nextCoordinates.add(next);
						visit[i-1][j] = true;
					}
					if(i < R-1 && map[i+1][j] == '.' && visit[i+1][j] == false) {
						int[] next = new int[2];
						next[0] = i+1;
						next[1] = j;
						
						nextCoordinates.add(next);
						visit[i+1][j] = true;
					}
					if(0 < j && map[i][j-1] == '.' && visit[i][j-1] == false) {
						int[] next = new int[2];
						next[0] = i;
						next[1] = j-1;
						
						nextCoordinates.add(next);
						visit[i][j-1] = true;
					}
					if(j < C-1 && map[i][j+1] == '.' && visit[i][j+1] == false) {
						int[] next = new int[2];
						next[0] = i;
						next[1] = j+1;
						
						nextCoordinates.add(next);
						visit[i][j+1] = true;
					}					
				}
				coordinates = nextCoordinates;
				
				if(minTime != -1) break;
			}
			
			////////////////////////////////////////////////////////////////////////////////////
			
			
			
			// 출력
			if(minTime == -1) {
				System.out.println("KAKTUS");
			}else {
				System.out.println(minTime);
			}			
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}