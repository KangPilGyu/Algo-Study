package baekjoon_string;
import java.util.*;
import java.io.*;
public class baekjoon_2799 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
		int[] rst = new int[5];
		br.readLine();
		for(int i = 0; i < input[0]; i++) {
			int[] window = new int[input[1]];
			for(int j = 0; j < 4; j++) {
				String[] arr = br.readLine().split("#");
				for(int k = 1; k < arr.length; k++) {
					String s = arr[k];
					if(s.startsWith("*")) window[k-1]++;
				}
			}
			br.readLine();
			for(int w : window) rst[w]++;
		}
		for(int i : rst) System.out.print(i+" ");
	}
}
