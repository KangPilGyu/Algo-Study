package baekjoon_graph_tree;
import java.util.*;
public class baekjoon_9237 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), max = 0;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
		Arrays.parallelSort(arr);
		for(int i = 0; i < n; i++) max = Math.max(max, arr[n-1-i] + i + 2);
		System.out.println(max);
	}
}
