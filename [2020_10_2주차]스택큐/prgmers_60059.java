package programmers;
import java.util.*;
public class prgmers_60059 {
	static int m, n;
	// 90도 회전
	static int[][] rotate(int[][] key){
		int[][] rtn = new int[m][m];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				rtn[i][j] = key[m - 1 - j][i];
			}
		}
		return rtn;
	}
	// x, y 만큼 이동
	static int[][] move(int[][] key, int x, int y){
		int[][] rtn = new int[n][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				int a = i + x;
				int b = j + y;
				if(0 <= a && 0 <= b && a < n && b < n) rtn[a][b] = key[i][j];
			}
		}
		return rtn;
	}
	
	static int count(int[][] lock, int[][] key) {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				cnt += lock[i][j] != key[i][j] ? 1 : 0;
			}
		}
		return cnt;
	}
	
	static public boolean solution(int[][] key, int[][] lock) {
		m = key.length;
		n = lock.length;
		int min = (n - 1) * - 1, max = n, cnt = 0, limit = n * n;
        
        // 완성된 자물쇠인지 확인
		for(int[] arr : lock) for(int i : arr) cnt += i;
		if(cnt == limit) return true;
		
        for(int i = 0; i < 4; i++) {
        	key = rotate(key);
        	for(int x = min; x < max; x ++) {
        		for(int y = min; y < max; y++) {
        			int[][] move = move(key, x, y);
        			
        			int count = count(lock, move);
        			if(count == limit) return true;
        		}
        	}
        }
        return false;
    }
	public static void main(String[] args) {
		System.out.println(solution(
			new int[][] {
				{1,1,1},
				{1,1,1}, 
				{1,1,1}
			},
			new int[][] {
				{1, 1, 1}, 
				{1, 1, 1}, 
				{1, 1, 0}
			}
		));

	}

}
