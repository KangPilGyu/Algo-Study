package programmers;
import java.util.*;
class Trie{
    int count = 0;
    Trie[] next = new Trie[26];
    Trie(){}
    void makeTrie(String str, int len, int idx){
        this.count++;
        if(len == idx) return;
        
        int at = str.charAt(idx) - 'a';
        if(this.next[at] == null) this.next[at] = new Trie();
        
        this.next[at].makeTrie(str, len, idx + 1);
    }
}
public class prgmers_60060 {
	static int findQuery(String str, int idx, Trie trie){
        if(str.charAt(idx) == '?') return trie.count;
        if(trie.next[str.charAt(idx) - 'a'] == null) return 0;
        return findQuery(str, idx + 1, trie.next[str.charAt(idx) - 'a']);
    }
    
	static String flipWord(String str){
        return new StringBuffer(str).reverse().toString();
    }
    
	static public int[] solution(String[] words, String[] queries) {
        int[] answer = new int [queries.length];
        
        Trie[] trie = new Trie[10001], back_trie = new Trie[10001];
        for(int i = 0; i < 10001; i++) {
        	trie[i] = new Trie();
        	back_trie[i] = new Trie();
        }
        
		for(String word : words){
            int len = word.length();
            trie[len].makeTrie(word, len, 0);
            back_trie[len].makeTrie(flipWord(word), len, 0);
        }
        
        for(int i = 0; i < queries.length; i++){
        	int len = queries[i].length();
            String query = queries[i].charAt(0) == '?' ? flipWord(queries[i]) : queries[i];
            Trie temp = queries[i].charAt(0) == '?' ? back_trie[len] : trie[len];
            answer[i] = findQuery(query, 0, temp);
        }
		return answer;
    }
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(
			new String[] {"frodo", "front", "frost", "frozen", "frame", "kakao"},
			new String[] {"fro??", "????o", "fr???", "fro???", "pro?"}
		)));

	}

}
