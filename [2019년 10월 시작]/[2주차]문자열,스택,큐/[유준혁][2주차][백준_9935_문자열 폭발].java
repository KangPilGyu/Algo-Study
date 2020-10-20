package workspace;
import java.util.*;
import java.io.*;
class algo_study_week2 {
	public static void main(String[] a) throws Exception {
		/*
		 * 첫 시도. 메모리 초과 발생. 최악의 경우 50만번 replace 해야 돼서 그런가..?
		 */
//		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        String boom = br.readLine();
//        while (str.contains(boom)) str = str.replaceAll(boom, "");
//        if (str.equals("")) System.out.println("FRULA");
//        else System.out.println(str);
		
		/*
		 * 두번째 시도. StringBuffer 에 계속 append를 하면서 마지막 boom.length 만큼의 String이 boom과 같은 지 확인하는 알고리즘
		 * 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String boom = br.readLine();
		int len = boom.length();
		int sbLen;
		StringBuffer sb = new StringBuffer(); // 결과를 저장해줄 StringBuffer
		for( byte b : str.getBytes() ) {
			sb.append((char)b);
			sbLen=sb.length();
			if(sbLen>=len) {
				String last = sb.substring(sbLen-len);
				if(last.equals(boom)) sb.delete(sbLen-len,sbLen);				
			}
		}
		str = sb.toString();
		if (str.equals("")) System.out.println("FRULA");
		else System.out.println(str);
	}
}
