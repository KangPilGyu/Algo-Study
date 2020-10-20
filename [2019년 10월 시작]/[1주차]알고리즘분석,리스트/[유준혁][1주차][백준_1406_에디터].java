package workspace;
import java.io.*;
import java.util.*;
import java.util.stream.*;
class Main {
	public static void main(String[] a) throws Exception{
		/*
		 * 첫번째 시도
		 * StringBuffer 의 insert 메소드때문에 시간초과가 나는 듯 함.
		 * JAVA DOC 찾아보니 AbstarctStringBuilder의 shift->System.arraycopy를 이용하는 걸 발견
		 * 추가,삭제 요청이 있을 때 마다 배열을 늘리고 줄이는 과정을 하다보니 시간이 오래걸리는 듯.
		 */
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuffer input = new StringBuffer(br.readLine());
//		int i=Integer.parseInt(br.readLine());
//		int index=input.length();
//		int len=index;
//		while(i-->0) {
//			String s = br.readLine();
//			switch(s.charAt(0)) {
//			case 'L':if(index>0)--index;break;
//			case 'D':if(index<len)++index;break;
//			case 'B':if(index>0) {input.deleteCharAt(--index);}break;
//			case 'P':input.insert(index++, s.charAt(2));len++;break;
//			}
//		}
//		System.out.println(new String(input));
		/*
		 * 두번째 시도
		 * 방식은 비슷하나 동적 메모리를 위해 Stack 사용.
		 * s1는 index 0부터 꺼내야 하고 s2는 top에서부터 꺼내야 올바르게 만들어짐. 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		for(byte b : br.readLine().getBytes())s1.add((char)b);
		int i=Integer.parseInt(br.readLine());
		while(i-->0) {
			String s = br.readLine();
			switch(s.charAt(0)) {
			case 'L':if(s1.size()>0)s2.add(s1.pop());break;
			case 'D':if(s2.size()>0)s1.add(s2.pop());break;
			case 'B':if(s1.size()>0)s1.pop();break;
			case 'P':s1.add(s.charAt(2));break;
			}
		}
		StringBuffer sb = new StringBuffer();
		for(i=0; i<s1.size(); i++)sb.append(s1.get(i));
		while(s2.size()>0)sb.append(s2.pop());
		System.out.println(sb);
	}
}
