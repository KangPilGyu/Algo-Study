import java.util.*;
class Main{
    static int fibo(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibo(n-1) + fibo(n-2);
	}
    public static void main(String[] x){
        System.out.println(fibo(new Scanner(System.in).nextInt()));
    }
}