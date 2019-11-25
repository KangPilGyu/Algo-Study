package week10;

import java.util.*;

/*
 * 백준_1730_집합
 * 
 * (1 ≤ x ≤ 20)
 * add x: S에 x를 추가.
 * remove x: S에서 x를 제거.
 * check x: S에 x가 있으면 1을, 없으면 0을 출력.
 * toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가.
 * all: S를 {1, 2, ..., 20} 으로 바꿈.
 * empty: S를 공집합으로 바꿈.
 * check 연산이 주어질때마다, 결과를 출력.
 */
public class Problem_11723 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();  // 연산의 수
		int S = 1;
		List<Integer> check = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			String inst = sc.next();
			int x = 0;
			if(!(inst.equals("all") || inst.equals("empty"))) {
				x = sc.nextInt();
			}
			
			switch(inst) {
			case "add" :
				if((S & (1 << x)) <= 1) {  // 해당 비트 꺼져 있음(존재하지 않음).
					S = S | (1 << x);  // 추가(or 연산은 무조건 1로 바꿔주니까)
				}
				break;
			case "remove" :
				if((S & (1 << x)) > 1) {  // 해당 비트 켜져 있음(존재함).
					S = S & ~(1 << x);  // 삭제(켜져 있는 비트의 not은 0이고, 0이랑 and 연산하면 무조건 0)
				}
				break;
			case "check" :
				if((S & (1 << x)) > 1) {
//					System.out.println(1);
					check.add(1);
				} else {
//					System.out.println(0);
					check.add(0);
				}
				break;
			case "toggle" :
				if((S & (1 << x)) > 1) {  // 해당 비트 켜져 있음(존재함).
					S = S & ~(1 << x);  // 삭제
				} else {
					S = S | (1 << x);  // 추가
				}
//				S = S ^ (1 << x);  // 토글
				break;
			case "all" :
				S = (1<<21)-1;
				break;
			case "empty" :
				S = 1;
				break;
			}
		}
		
		for(int c : check) {
			System.out.println(c);
		}
		
//		Scanner sc = new Scanner(System.in);
//		boolean[] arr = new boolean[21];
//		int n = sc.nextInt();
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < n; i++) {
//			String s = sc.next();
//			switch (s) {
//			case "add":
//				arr[sc.nextInt()] = true;
//				break;
//			case "remove":
//				arr[sc.nextInt()] = false;
//				break;
//			case "toggle":
//				int x = sc.nextInt();
//				arr[x] = !arr[x];
//				break;
//			case "check":
//				sb.append((arr[sc.nextInt()] ? 1 : 0) + "\n");
//				break;
//			case "all":
//				for (int j = 0; j < 21; j++)
//					arr[j] = true;
//				break;
//			case "empty":
//				for (int j = 0; j < 21; j++)
//					arr[j] = false;
//				break;
//			}
//		}
//		System.out.println(sb.toString());
	}
}
