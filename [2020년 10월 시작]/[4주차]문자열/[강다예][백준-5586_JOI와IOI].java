import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jh5586 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		int cnt1 = 0;
		int cnt2 = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == 'O') {
				continue;
			}

			if (arr[i] == 'J') {
				if (arr[i + 1] == 'O' && arr[i + 2] == 'I')
					cnt1++;
			} else if (arr[i] == 'I') {
				if (arr[i + 1] == 'O' && arr[i + 2] == 'I')
					cnt2++;
			}
		}
		
		System.out.println(cnt1);
		System.out.println(cnt2);
	}
}
