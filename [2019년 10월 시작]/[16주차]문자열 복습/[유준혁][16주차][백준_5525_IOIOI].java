package baekjoon_string;
import java.util.*;
public class baekjoon_5525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), len = sc.nextInt(), rst = 0;
		byte[] arr = sc.next().getBytes();
		for(int i = 0; i < len; i++) {
			int m = 0;
			while(arr[i] == 'I') {
				if(i + 2 < len && arr[i+1] == 'O' && arr[i+2] == 'I') {
					m++;
					i += 2;
				}else break;
			}
			if(n <= m) rst += m - n + 1;
		}
		System.out.println(rst);
	}
}
