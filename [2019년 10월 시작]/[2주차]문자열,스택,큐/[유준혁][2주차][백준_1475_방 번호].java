package workspace;
import java.util.*;
public class baekjoon_1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int [] arr = new int [10]; //0~9까지 저장할 배열
		for(String s : input.split("")) {
			int i = Integer.parseInt(s);
			arr[i]+=1;
		}
		int sixnine = (int) Math.ceil((arr[6] + arr[9])/2.0);
		arr[6]=sixnine; arr[9]=sixnine;
		System.out.println(Arrays.stream(arr).max().getAsInt());
	}
}
