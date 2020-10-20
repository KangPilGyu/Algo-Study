package baekjoon_math;
import java.util.*;
public class baekjoon_1016 {
	public static boolean isPrime(long l) {
		for(int i=2; i<(int)Math.sqrt(l)+1; i++) {
			if(l%i==0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		List<Long> list = new ArrayList<>();
		Set<Long> set = new HashSet<>();
		for(long i=2; i<Math.sqrt(max)+1; i++) {
			if(isPrime(i)) list.add((long)Math.pow(i, 2));
		}
		for(int i=0; i<list.size(); i++) {
			long pow = list.get(i);
			long val = pow > min ? pow : pow * (min/pow);
			while(val <= max) {
				if(min <= val && val <= max) set.add(val);
				val += pow;
			}
		}
		System.out.println(max-min-set.size()+1);
	}
}
