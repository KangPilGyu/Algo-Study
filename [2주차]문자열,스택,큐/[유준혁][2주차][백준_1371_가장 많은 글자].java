package workspace;
import java.util.*;
import java.io.*;
public class baekjoon_1371 {
	public static void main(String[] args) throws Exception{
		//첫번째 시도. 겉보기에는 문제가 없어보이는데 while문을 빠져나오지를 못함. 검색 결과 EOF라는 걸 발견
//		Scanner sc = new Scanner(System.in);
//		int [] arr = new int [26];
//		while(sc.hasNext()){
//			for(byte b : sc.next().getBytes()) arr[b-'a']++;
//		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] arr = new int [26];
		String s;
		while((s=br.readLine()) != null) { //EOF를 읽으면 null을 반환한다.
			for(byte b : s.getBytes()) {
				if(b==' ') continue;
				arr[b-'a']++;
			}
		}
		int max=Arrays.stream(arr).max().getAsInt();
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==max) System.out.print((char)('a'+i));
		}
	}
}
