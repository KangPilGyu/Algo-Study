package workspace;
import java.util.*;
public class baekjoon_1966 {
	public static int solution(int[] priorities, int location) {
        int max = Arrays.stream(priorities).max().getAsInt();
        int cnt = 0;
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        for(int i : priorities) {
        	q1.offer(i);
        	q2.offer(cnt++);
        }
        cnt=0;
        while(!q1.isEmpty()) {
        	int i1 = q1.poll();
        	int i2 = q2.poll();
        	if(i1==max) {
        		priorities[i2]=-1;
        		cnt++;
        		if(i2==location)break;
        		max = Arrays.stream(priorities).max().getAsInt();
        	}
        	else {
        		q1.offer(i1);
        		q2.offer(i2);
        	}
        }
        return cnt;
    }
	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);
		int rnd = sc.nextInt();
		for(int i=0; i<rnd; i++) {
			int N=sc.nextInt(), M=sc.nextInt();
			int [] arr = new int [N];
			for(int j=0; j<N; j++) arr[j]=sc.nextInt();
			System.out.println(solution(arr,M));
		}
	}
}
