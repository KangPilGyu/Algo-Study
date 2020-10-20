package workspace;
import java.util.*;
public class baekjoon_1032 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char [][] arr = new char [sc.nextInt()][];
		for(int i=0; i<arr.length; i++) arr[i] = sc.next().toCharArray();
		String s = "";
		for(int i=0; i<arr[0].length; i++) {
			int j=0;
			char c = arr[j][i];
			for(; j<arr.length; j++) {
				if (c!=arr[j][i]){
					s+="?";
					break;
				}
				if(j==arr.length-1) s+=c;
			}
		}
		System.out.println(s);
	}
}
