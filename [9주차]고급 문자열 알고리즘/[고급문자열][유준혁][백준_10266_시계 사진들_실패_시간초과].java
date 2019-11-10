package baekjoon_string2;
import java.util.*;
import java.io.*;
public class baekjoon_10266 {
	public static boolean equal(Queue<Integer> cha1, Queue<Integer> cha2) {
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		
		cha1.forEach(s -> q1.add(s));
		cha2.forEach(s -> q2.add(s));
		
		while(!q1.isEmpty()) {
			if(q1.poll().compareTo(q2.poll()) != 0) return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
		int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
		int len = arr1.length;
		Arrays.sort(arr1); Arrays.sort(arr2);
		Queue<Integer> cha1 = new LinkedList<>();
		Queue<Integer> cha2 = new LinkedList<>();
		
		for(int i=0; i<len; i++) {
			if(i == len - 1)cha1.add(360000 - arr1[i] + arr1[0]);
			else cha1.add(arr1[i + 1] - arr1[i]);
		}
		for(int i=0; i<len; i++) {
			if(i == len - 1)cha2.add(360000 - arr2[i] + arr2[0]);
			else cha2.add(arr2[i + 1] - arr2[i]);
		}
		
		for(int i=0; i<len; i++) {
			if(cha1.peek().compareTo(cha2.peek()) == 0) {
				if(equal(cha1, cha2)) {
					System.out.println("possible");
					return;
				}
			}else {
				cha2.add(cha2.poll());
			}
		}
		System.out.println("impossible");
	}
}
