package week_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backjoon_5622 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언

		int[] seconds = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10};
		int cnt = 0;
		while (true) {
			try {
				int alpha = bf.read();
				cnt+=seconds[alpha-'A'];
			} catch (Exception e){
				break;
			}
		}
		System.out.println(cnt);
	}
}
