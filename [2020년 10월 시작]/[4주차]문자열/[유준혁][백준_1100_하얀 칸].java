import java.util.*;
class Main{
	public static void main(String[]x){
		Scanner sc=new Scanner(System.in);
		int idx = 0,cnt = 0;
		for(int i = 0; i < 8; i++){
			for(String s : sc.next().split("")){
				if(idx % 2 == 0 && s.equals("F")) cnt++;
				idx++;
			}
			idx--;
		}
		System.out.println(cnt);
	}
}
