import java.util.*;
class Main{
	public static void main(String[] ar){
		Scanner sc = new Scanner(System.in);
		int cnt = 0, max = 0;
		for(int i = 0; i < 4; i++){
			cnt += (sc.nextInt() * -1) + sc.nextInt();
			max = Math.max(max, cnt);
		}
		System.out.println(max > 10000 ? 10000 : max);
	}
}
