package baekjoon_brute_force;
import java.util.*;
public class baekjoon_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = new int [9];
		for(int i=0; i<9; i++) arr[i] = sc.nextInt();
		int cha = Arrays.stream(arr).sum() - 100; // 9명 난쟁이 키의 합 에서 100을 뺌.
		boolean stop = false; // for문에서의 조건을 추가적으로 부여해줄 불리언
		
		for(int i=0; i<arr.length - 1 && !stop; i++) {
			for(int j=i+1; j<arr.length && !stop; j++) {
				int temp = arr[i] + arr[j]; // i+j의 값이 cha와 같다면 그 둘은 거짓난쟁이!
				if(temp == cha) {
					int a=arr[i], b=arr[j]; // 잠깐 값을 저장해줄 변수
					Arrays.sort(arr); // Arrays 클래스의 sort 메서드 사용
					for(int ii : arr) 
						if(ii != a && ii != b) 
							System.out.println(ii);
					stop = true; // stop을 true로 바꿔서 2중 for문을 모두 빠져나가게끔 해줌.
				}
			}
		}
	}
}
