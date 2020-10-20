package baekjoon_trie;
import java.util.*;
import java.io.*;
public class baekjoon_4358 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<>();
		double cnt = 0;
		String s = "";
		while(!(s = br.readLine()).equals("stop")) {
			map.put(s, map.getOrDefault(s, 0) + 1);
			cnt++;
		}
		List<String> list = new ArrayList<>();
		list.addAll(map.keySet());
		list.sort(null);
		for(String str : list) {
			System.out.println(str + " " + String.format("%.4f", (map.get(str) / cnt * 100)));
		}
	}
}