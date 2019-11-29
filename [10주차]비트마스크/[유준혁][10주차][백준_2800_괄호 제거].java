package baekjoon_bitmask;
import java.util.*;
public class baekjoon_2800 {
	static Set<String> set = new HashSet<>();
    static int[] brac;
    static int last;
    static void func(StringBuffer sb, int bit, int layer, int idx, int val){
        if(val > last || idx >= sb.length()) {
           if(bit != 0) set.add(new String(sb).replace(".", "")); 
           return;
        }
        for(; idx < sb.length(); idx++){
            if(brac[idx] == val){
               func(new StringBuffer(sb), bit, layer + 1, idx+1, val + 1);
               break;
            }
        }
        for(int i=idx; i < sb.length(); i++) {
           if(brac[i] == val) sb.replace(i, i+1, ".");
        }
        func(new StringBuffer(sb), (bit | (1 << layer)), layer + 1, idx + 1, val + 1);
    }
    
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        brac = new int [s.length()];
        Stack<Integer> stack = new Stack<>();
        int i = 1, idx = 0;
        for(byte b : s.getBytes()){
            if(b == '(') {
                stack.push(i);
                brac[idx] = i++;
            }else if (b == ')'){
                brac[idx] = stack.pop();
            }
            idx++;
        }
        last = i - 1;
        StringBuffer sb = new StringBuffer(s);
        
        func(sb, 0, 0, 0, 1);
        
        set.stream().sorted().forEachOrdered(x -> System.out.println(x));
    }
}
