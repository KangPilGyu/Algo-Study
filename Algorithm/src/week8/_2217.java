package week8;

import java.util.Arrays;
import java.util.Scanner;

public class _2217 {

	public static void main(String[] args) {

		_2217();

	}

	private static void _2217() {
		Scanner sc = new Scanner(System.in);
		int[] rope = new int[sc.nextInt()];
		int[] result = new int[rope.length];
		int min = result[0];

		for (int i = 0; i < rope.length; i++) {
			rope[i] = sc.nextInt();
		}
		
		Arrays.sort(rope);
		
		for (int i = 0; i > result.length; i++) {
			 int next = rope[i]/2;
			if(rope[i+1] < next  ) {
				result[i] = rope[i]; 
				if(min > result[i]) {
					min = result[i];
					int res	= min * result.length;
					System.out.println(res);
				}
			}
		}

	}

}
