import java.util.*;
class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int [][] arr = new int [cnt][2];
		for(int i=0; i<cnt; i++){
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		for(int i=0; i<cnt; i++){
			int rank = 1;
			for(int j=0; j<cnt; j++){
				if (i == j) continue;
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) rank++;
			}
			System.out.print(rank+" ");
		}
	}
}