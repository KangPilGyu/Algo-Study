package week_2;

import java.util.Scanner;

public class backjoon_2941 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String str = scanner.next();
		char[] chAry = str.toCharArray();
		int croatiaCnt = 0;
		for (int i = 0; i < chAry.length; i++) {
			switch(chAry[i]) {
			case 'c':
				if (i+1 < chAry.length && (chAry[i+1] == '=' || chAry[i+1] == '-')) {
					i++;
				}
				break;
			case 'd':
				if (i+1 < chAry.length && chAry[i+1] == '-') {
					i++;
				} else if (i+2 < chAry.length && chAry[i+1] == 'z' && chAry[i+2] == '=') {
					i +=2;
				}
				break;
			case 'l':
			case 'n':
				if (i+1 < chAry.length && chAry[i+1] == 'j') {
					i++;
				}
				break;
			case 's':
			case 'z':
				if (i+1 < chAry.length && chAry[i+1] == '=') {
					i++;
				}
				break;
			}
			croatiaCnt++;

		}
		System.out.println(croatiaCnt);
	}
}

// 1년전 풀이 코드
// 1년전이 풀이가 더 좋은 거 같은 느낌?
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[] croaAlpha= {"dz=","c=","z=","c-","d-","lj","nj","s="};

		Scanner scanner= new Scanner(System.in);
		String str= scanner.next();
		int sum=0;
		String tempStr=str;

		for (int i = 0; i < croaAlpha.length; i++) {
				tempStr=tempStr.replaceAll(croaAlpha[i], ""+i);
				sum+=count(tempStr,""+i);
		}
		for (int i = 0; i < croaAlpha.length; i++) {
			tempStr=tempStr.replaceAll(i+"", "");
		}

		System.out.println(sum+tempStr.length());
		scanner.close();
	}

	private static int count(String tempStr,String com) {
		char[] ary = tempStr.toCharArray();
		int sum=0;
		for (int i = 0; i < ary.length; i++) {
			if(com.equals(""+ary[i])) sum++;
		}
		return sum;
	}
}
