import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jh1100 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				if (arr[j] == 'F' && (i+j)%2 ==0) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}
/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			char[] arr = br.readLine().toCharArray();
			if (i % 2 == 0) { //Èò»ö¸ÕÀú
				for (int j = 0; j <= 3; j++) {
					if (arr[2 * j] == 'F') {
						cnt++;
					}
				}
			} else {//²­Á¤¸ÕÀú
				for (int j = 0; j <= 3; j++) {
					if (arr[2 * j + 1] == 'F') {
						cnt++;
					}
				}
			}
			
		}
		
		System.out.println(cnt);
	}
}
*/