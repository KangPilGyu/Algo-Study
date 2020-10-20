package baekjoon_greedy;
import java.util.*;
public class baekjoon_1931 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<int[]> list = new ArrayList<>();
		int n = sc.nextInt();
		for(int i=0; i<n; i++) 
			list.add(new int [] {sc.nextInt(), sc.nextInt()});
		
		list.sort((arr1, arr2)-> {
			int val = arr1[1] - arr2[1];
			if(val == 0) return arr1[0] - arr2[0];
			return val;
		});
		
		int cnt = 0;
		int last = 0;
		for(int[] arr : list) {
			if(last <= arr[0]) {
				last = arr[1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
