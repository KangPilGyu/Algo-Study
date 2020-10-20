package workspace;
import java.io.*;
import java.util.*;
import java.util.stream.*;
class Main {
	public static void main(String[] a) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=Integer.parseInt(br.readLine());		
		while(cnt-->0) {
			Stack<Character> s1 = new Stack<>();
			Stack<Character> s2 = new Stack<>();
			StringBuffer sb = new StringBuffer();
			String s = br.readLine();
			for(byte b : s.getBytes()) {
				switch((char)b) {
				case '<':if(s1.size()>0)s2.add(s1.pop());break;
				case '>':if(s2.size()>0)s1.add(s2.pop());break;
				case '-':if(s1.size()>0)s1.pop();break;
				default:s1.add((char)b);break;
				}
			}
			for(int i=0; i<s1.size(); i++)sb.append(s1.get(i));
			while(s2.size()>0)sb.append(s2.pop());
			System.out.println(sb);
		}
	}
}
