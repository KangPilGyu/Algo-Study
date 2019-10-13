package baekjoon_DFS_BFS;
import java.util.*;
public class baekjoon_2606 {
	static int [][] arr;
	static boolean [] visit;
	static void func(int idx) {
		visit[idx] = true;
		for(int i=0; i<arr.length; i++) {
			if(arr[i][0] == idx && !visit[arr[i][1]])
				func(arr[i][1]);
			if(arr[i][1] == idx && !visit[arr[i][0]])
				func(arr[i][0]);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int [m][2];
		visit = new boolean [n+1];
		for(int i=0; i<m; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		func(1);
		int sum = 0;
		for(int i=0; i<n+1; i++) if(visit[i]) sum++;
		System.out.println(sum - 1);
	}
}
/*
7
6
1 2
2 4
1 5
4 5
1 4
6 7
----------
7
6
1 2
2 3
1 5
5 2
5 6
4 7
*/