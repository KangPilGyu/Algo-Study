package programmers;

import java.util.*;
public class prgmers_60061 {
	static boolean check(int n, int[][] col, int[][] row) {
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < n; j++) {
				if(i < n && col[i][j] == 1) {
					boolean underCol = i == 0 || (i > 0 && col[i-1][j] == 1);
					boolean underRow = (j > 0 && row[i][j-1] == 1) || row[i][j] == 1;
					if((underCol || underRow) == false) return false;
				}
				if(row[i][j] == 1) {
					boolean underCol = i > 0 && (col[i-1][j] == 1 || col[i-1][j+1] == 1);
					boolean nearRow = (j > 0 && j < n - 1) && (row[i][j-1] == 1 && row[i][j+1] == 1);
					if((underCol || nearRow) == false) return false;
				}
			}
		}
		return true;
	}
	static public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        int[][] col = new int[n][n+1], row = new int[n+1][n];
        for(int[] frame : build_frame) {
        	int x = frame[1], y = frame[0], a = frame[2], b = frame[3];
        	int[][] tmp = a == 0 ? col : row;
        	tmp[x][y] = b;
        	if(check(n, col, row) == false) tmp[x][y] = b == 0 ? 1 : 0;
        }
        
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
        	for(int j = 0; j < n + 1; j++) {
        		if(i < n && col[i][j] == 1) list.add(new int[] {j, i, 0});
        		if(j < n && row[i][j] == 1) list.add(new int[] {j, i, 1});
        	}
        }
        list.sort((a, b)->{
        	int x = a[0] - b[0];
        	int y = a[1] - b[1];
        	int t = a[2] - b[2];
        	if(x != 0) return x;
        	if(y != 0) return y;
        	return t;
        });
        
        answer = new int[list.size()][];
        for(int i = 0; i < answer.length; i++) answer[i] = list.get(i);
        return answer;
    }
	public static void main(String[] args) {
		int[][] arr = solution(5, func("[[0,0,0,1],[0,1,0,1],[0,2,0,1],[0,3,0,1],[0,4,0,1],[0,5,1,1]]"));
		for(int[] a : arr) System.out.println(Arrays.toString(a));
	}
	static int[][] func(String str){
		str = str.replaceAll("[^0-9,]","A");
		String[] arr = str.split("A,A");
		int[][] rtn = new int[arr.length][];
		int idx = 0;
		for(String s : arr) {
			s = s.replaceAll("[A]", "");
			String[] split = s.split(",");
			rtn[idx] = new int[split.length];
			for(int i = 0; i < split.length; i++) rtn[idx][i] = Integer.parseInt(split[i]);
			idx++;
		}
		return rtn;
	}
}
