package baekjoon_math;
import java.util.*;
public class baekjoon_1652 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] room = new String[sc.nextInt()];
		int width=0, height=0;
		for(int i=0; i<room.length; i++) {
			room[i]=sc.next();
			String [] arr = room[i].split("X");
			for(String s : arr) {
				if(s.length()>1) width++;
			}
		}
		for(int i=0; i<room.length; i++) {
			StringBuffer sb = new StringBuffer();
			for(int j=0; j<room.length; j++) {
				sb.append(room[j].charAt(i));
			}
			for(String s : sb.toString().split("X")) {
				if(s.length()>1) height++;
			}
		}
		System.out.println(width+" "+height);
		
	}
}
