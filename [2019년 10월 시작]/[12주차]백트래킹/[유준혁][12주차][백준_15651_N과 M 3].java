package baekjoon_backtracking;
import java.util.*;
import java.io.*;
public class baekjoon_15651 {
	static int n, m;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void func(int cnt, String s) throws Exception{
		if(cnt == m) {
			bw.write(s.trim()+"\n");
			return;
		}
		for(int i=1; i<=n; i++) {
			func(cnt + 1, s + i + " ");
		}
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		func(0, "");
		bw.flush();
	}
}
