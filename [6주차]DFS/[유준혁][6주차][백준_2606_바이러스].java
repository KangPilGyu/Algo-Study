package baekjoon_DFS_BFS;
import java.util.*;
public class baekjoon_2606 {
	static int [][] arr;
	static Set<Integer> set = new HashSet<>();
	static void func(int idx) {
		set.add(idx);
		for(int i=0; i<arr.length; i++)
			if(arr[i][0] == idx && !set.contains(arr[i][1])) {
//				System.out.println("현재 i ->"+i+", 현재 idx ->"+idx+", 새로 불러들인 idx ->"+arr[i][1]);
				func(arr[i][1]);
			}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		int m = sc.nextInt();
		arr = new int [m+1][2];
		for(int i=0; i<m; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		for(int [] ar : arr) {
			for(int i : ar) System.out.print(i+" ");
			System.out.println();
		}
		func(1);
		System.out.println(set.size() - 1);
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