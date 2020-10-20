package week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언

		String str = bf.readLine();
		String boom = bf.readLine();
		int boomlength = boom.length();

//
//		int idx = 0;
//		while((idx = str.indexOf(boom, idx)) != -1) {
//			str.delete(idx, idx+boomlength);
//			idx = (boomlength > idx) ? 0 : idx-boomlength;
//		}
//
//		if (str.length() == 0) {
//			System.out.println("FRULA");
//		} else {
//			System.out.println(str);
//		}

		StringBuffer sbuffer = new StringBuffer();
		for (char ch : str.toCharArray()) {
			sbuffer.append(ch);
			if (ch == boom.charAt(boomlength-1) && sbuffer.length() >= boomlength) {
				if (sbuffer.substring(sbuffer.length() - boomlength).equals(boom))
					sbuffer.delete(sbuffer.length() - boomlength, sbuffer.length());
				}
		}
		if (sbuffer.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sbuffer);
		}

	}
}
