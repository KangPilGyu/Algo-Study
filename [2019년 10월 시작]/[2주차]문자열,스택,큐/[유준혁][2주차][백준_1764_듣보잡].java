package workspace;
import java.util.*;
import java.io.*;
public class baekjoon_1764 {
	public static void main(String[] args) throws Exception{
		//첫번째 시도. 알고리즘은 맞는 듯 하나 시간초과 발생.
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		List<String> list1 = new ArrayList<>();
//		List<String> list2 = new ArrayList<>();
//		String [] arr = br.readLine().split(" ");
//		for(int i=0; i<Integer.parseInt(arr[0]); i++) list1.add(br.readLine());
//		for(int i=0; i<Integer.parseInt(arr[1]); i++) {
//			String s = br.readLine();
//			if(list1.contains(s)) list2.add(s);
//		}
//		list2.sort(null);
//		for(String s : list2) System.out.println(s);
		
		//두번째 시도. Set을 사용해서 contains의 시간복잡도를 O(1)로 줄였으나 틀렸다고 나옴.
		//두번째 for문을 돌면서 같은 이름이 2번 이상 나온다면 틀릴 수 있음. (보도 못한 사람이 obama, obama, clinton 인 경우)
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Set<String> set = new HashSet<>();
//		List<String> list = new ArrayList<>();
//		String [] arr = br.readLine().split(" ");
//		for(int i=0; i<Integer.parseInt(arr[0]); i++) set.add(br.readLine());
//		for(int i=0; i<Integer.parseInt(arr[1]); i++) {
//			String s = br.readLine();
//			if(set.contains(s)) list.add(s);
//		}
//		list.sort(null);
//		for(String s : list)System.out.println(s);
		
		//세번째 시도. 
		//Set 2개를 사용하고 마지막으로 list에 넣은 뒤 정렬했지만 여전히 틀렸다고 나옴...
		//아 출력 첫 줄에 결과가 몇개인지 출력해야되는구나....
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		List<String> list = new ArrayList<>();
		String [] arr = br.readLine().split(" ");
		for(int i=0; i<Integer.parseInt(arr[0]); i++) set1.add(br.readLine());
		for(int i=0; i<Integer.parseInt(arr[1]); i++) {
			String s = br.readLine();
			if(set1.contains(s)) set2.add(s);
			if(set1.size() == set2.size()) break;
		}
		list.addAll(set2);
		list.sort(null);
		System.out.println(list.size());
		for(String s : list)System.out.println(s);
	}
}
