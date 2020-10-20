package inputoutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.
n은 1이상 8000000000 이하인 자연수입니다.

n			return
118372	873211
*/
public class pg {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();

		String[] arr = n.split("");
		int[] num = new int[n.length()];
		
		for (int i = 0; i < arr.length; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		
		Arrays.sort(num);
		
		for (int i = num.length-1; i >= 0; i--) {
			System.out.print(num[i]);
		}

	}

}
