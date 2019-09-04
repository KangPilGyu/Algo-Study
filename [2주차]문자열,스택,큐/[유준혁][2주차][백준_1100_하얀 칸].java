package workspace;
import java.util.*;
public class baekjoon_1100 {
	public static void main(String[] args) {
		//첫번째 방법.
//		Scanner sc = new Scanner(System.in);
//		int [][] chess = new int [8][8];
//		int cnt = 0;
//		for(int i=0; i<8; i++) {
//			String input = sc.next();
//			for(int j=0; j<8; j++) {
//				if(input.charAt(j)=='F') {
//					chess[i][j]=1;
//				}
//			}
//		}
//		for(int i=0; i<8; i++) {
//			for(int j=0; j<8; j++) {
//				if((i+j)%2==0 && chess[i][j]==1) cnt++;
//			}
//		}
//		System.out.println(cnt);
		
		//두번째 방법.
		Scanner sc = new Scanner(System.in);
		int idx=0;
		int cnt=0;
		for(int i=0; i<8; i++) {
			for(String s:sc.next().split("")) {
				if(idx%2==0 && s.equals("F")) cnt++;
				idx++;
			}
			idx--;
		}
		System.out.println(cnt);
	}
}
