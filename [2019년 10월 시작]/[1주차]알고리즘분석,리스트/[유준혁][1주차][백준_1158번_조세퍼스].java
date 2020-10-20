package workspace;
import java.util.*;
class Main {
	public static void main(String[] a){
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(),K=sc.nextInt();
		sc.close();
		/*기존에 했다가 틀린 방식.
		 *문제 이해를 잘못해서 요상한 코드가 나왔음.
		 *7 3 이 입력된다고 가정하면
		 *1,2,3,4,5,6,7 에서 k-1을 시작점으로 두고(2) k번째까지 이동.(0부터로 생각했음)
		 *1,2,3,4,5,6,7 -> [0,0,0,0,0,1,0] 이렇게 1단계. index는 현재 5인 상태
		 *1,2,3,4,5,6,7 -> [0,0,2,0,0,1,0] 이렇게 2단계. index가 size를 넘어가면 index = index%size
		 *쭉쭉쭉 하다보니 결과가 얼추 비슷하길래 이건가 싶어서 꼼꼼히 안챙겨봤음 ㅎㅅㅎ...
		 */
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<N+1; i++)list.add(i);
		int cnt=1,k=K-1;
		int [] result = new int [N];
		while(!list.isEmpty()) {
			k+=K;
			if(k>=list.size())k%=list.size();
			int i=list.get(k);
			result[i-1]=cnt++;
			list.remove(k);
		}
		for(int i=0; i<result.length; i++) {
			if(i==0)System.out.print("<");
			if(i<result.length-1)System.out.print(result[i]+", ");
			else System.out.print(result[i]+">");
		}

		/*문제 이해하고 난 후 코드*/
		Queue<Integer> que = new LinkedList<>();
		for(int i=1; i<N+1; i++)que.add(i);
		System.out.print("<");
		while(!que.isEmpty()) {
			for(int i=0; i<K; i++) {
				if(i==K-1)System.out.print(que.poll());
				else {
					que.add(que.poll());
				}
			}
			if(que.isEmpty())System.out.print(">");
			else System.out.print(", ");
		}
	}
}
