import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jh1543 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		
		int cnt = 0;
		for (int i = 0; i <=a.length()-b.length(); i++) {			
			if (a.substring(i, i+b.length()).equals(b)) {
				i += b.length() - 1;				
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
	}
}