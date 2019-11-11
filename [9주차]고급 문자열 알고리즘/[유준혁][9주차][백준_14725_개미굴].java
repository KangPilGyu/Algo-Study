package baekjoon_string2;
import java.util.*;
import java.io.*;
class Trie {
    String val;
    List<Trie> dict = new ArrayList<>();
    public Trie() {}
    public Trie(String s){
        this.val = s;
    }
    public void add(String[] arr, int idx){
        boolean find = false;
        for(Trie t : dict) {
            if(t.val.equals(arr[idx])){
                t.add(arr, idx + 1);
                find = true;
            }
       }
        if(!find){
            dict.add(new Trie(arr[idx]));
            if (idx < arr.length - 1) add(arr, idx);
        }
    }
    
    public void print(int i) {
       dict.sort((t1, t2) -> {
          return t1.val.compareTo(t2.val);
       });
       for(Trie t : dict) {
           for(int a=0; a<i; a++) System.out.print("--");
          System.out.println(t.val);
          t.print(i + 1);
       }
    }
}
public class baekjoon_14725 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        while(n-->0){
            String[] arr = br.readLine().split(" ");
            trie.add(arr, 1);
        }
        trie.print(0);
	}
}
